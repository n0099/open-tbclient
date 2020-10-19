package com.baidu.swan.games.audio;
/* loaded from: classes10.dex */
public class c {
    private static volatile int dCn;

    public static synchronized int aOh() {
        int i;
        synchronized (c.class) {
            i = dCn;
            dCn = i + 1;
        }
        return i;
    }
}
