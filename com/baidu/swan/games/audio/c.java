package com.baidu.swan.games.audio;
/* loaded from: classes2.dex */
public class c {
    private static volatile int beE;

    public static synchronized int QO() {
        int i;
        synchronized (c.class) {
            i = beE;
            beE = i + 1;
        }
        return i;
    }
}
