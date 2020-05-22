package com.baidu.swan.games.audio;
/* loaded from: classes11.dex */
public class c {
    private static volatile int cTB;

    public static synchronized int axn() {
        int i;
        synchronized (c.class) {
            i = cTB;
            cTB = i + 1;
        }
        return i;
    }
}
