package com.baidu.swan.games.audio;
/* loaded from: classes9.dex */
public class c {
    private static volatile int cfp;

    public static synchronized int aiA() {
        int i;
        synchronized (c.class) {
            i = cfp;
            cfp = i + 1;
        }
        return i;
    }
}
