package com.baidu.swan.games.audio;
/* loaded from: classes8.dex */
public class c {
    private static volatile int ead;

    public static synchronized int aTz() {
        int i;
        synchronized (c.class) {
            i = ead;
            ead = i + 1;
        }
        return i;
    }
}
