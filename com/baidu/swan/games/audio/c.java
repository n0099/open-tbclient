package com.baidu.swan.games.audio;
/* loaded from: classes2.dex */
public class c {
    private static volatile int aZO;

    public static synchronized int Ne() {
        int i;
        synchronized (c.class) {
            i = aZO;
            aZO = i + 1;
        }
        return i;
    }
}
