package com.baidu.swan.games.audio;
/* loaded from: classes8.dex */
public class c {
    private static volatile int edL;

    public static synchronized int aTO() {
        int i;
        synchronized (c.class) {
            i = edL;
            edL = i + 1;
        }
        return i;
    }
}
