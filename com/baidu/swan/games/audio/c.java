package com.baidu.swan.games.audio;
/* loaded from: classes8.dex */
public class c {
    private static volatile int doi;

    public static synchronized int aKN() {
        int i;
        synchronized (c.class) {
            i = doi;
            doi = i + 1;
        }
        return i;
    }
}
