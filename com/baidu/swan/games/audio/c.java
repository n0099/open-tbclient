package com.baidu.swan.games.audio;
/* loaded from: classes2.dex */
public class c {
    private static volatile int aZL;

    public static synchronized int Ng() {
        int i;
        synchronized (c.class) {
            i = aZL;
            aZL = i + 1;
        }
        return i;
    }
}
