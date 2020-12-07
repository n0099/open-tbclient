package com.baidu.swan.games.audio;
/* loaded from: classes25.dex */
public class c {
    private static volatile int dVS;

    public static synchronized int aUY() {
        int i;
        synchronized (c.class) {
            i = dVS;
            dVS = i + 1;
        }
        return i;
    }
}
