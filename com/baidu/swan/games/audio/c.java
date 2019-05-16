package com.baidu.swan.games.audio;
/* loaded from: classes2.dex */
public class c {
    private static volatile int bdQ;

    public static synchronized int PW() {
        int i;
        synchronized (c.class) {
            i = bdQ;
            bdQ = i + 1;
        }
        return i;
    }
}
