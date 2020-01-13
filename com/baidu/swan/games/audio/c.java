package com.baidu.swan.games.audio;
/* loaded from: classes10.dex */
public class c {
    private static volatile int cfC;

    public static synchronized int aiT() {
        int i;
        synchronized (c.class) {
            i = cfC;
            cfC = i + 1;
        }
        return i;
    }
}
