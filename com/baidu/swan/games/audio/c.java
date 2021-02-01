package com.baidu.swan.games.audio;
/* loaded from: classes9.dex */
public class c {
    private static volatile int eck;

    public static synchronized int aTL() {
        int i;
        synchronized (c.class) {
            i = eck;
            eck = i + 1;
        }
        return i;
    }
}
