package com.baidu.swan.games.audio;
/* loaded from: classes10.dex */
public class c {
    private static volatile int dKK;

    public static synchronized int aQb() {
        int i;
        synchronized (c.class) {
            i = dKK;
            dKK = i + 1;
        }
        return i;
    }
}
