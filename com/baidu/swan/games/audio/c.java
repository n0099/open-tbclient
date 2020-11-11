package com.baidu.swan.games.audio;
/* loaded from: classes10.dex */
public class c {
    private static volatile int dQC;

    public static synchronized int aSB() {
        int i;
        synchronized (c.class) {
            i = dQC;
            dQC = i + 1;
        }
        return i;
    }
}
