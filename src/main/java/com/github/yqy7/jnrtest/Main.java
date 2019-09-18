package com.github.yqy7.jnrtest;

import jnr.ffi.LibraryLoader;
import jnr.ffi.Platform;
import jnr.ffi.Platform.OS;

public class Main {
    public static interface LibC {
        int puts(String s);
    }

    public static void main(String[] args) {
        LibC libc = LibraryLoader.create(LibC.class)
            .load(Platform.getNativePlatform().getOS() == OS.WINDOWS ? "msvcrt" : "c");

        libc.puts("Hello, World...");
    }
}
