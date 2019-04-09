package com.baidu.swan.games.audio;
/* loaded from: classes2.dex */
public class c {
    private static volatile int aZP;

    public static synchronized int Ne() {
        int i;
        synchronized (c.class) {
            i = aZP;
            aZP = i + 1;
        }
        return i;
    }
}
