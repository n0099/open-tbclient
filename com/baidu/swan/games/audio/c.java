package com.baidu.swan.games.audio;
/* loaded from: classes11.dex */
public class c {
    private static volatile int cjT;

    public static synchronized int alm() {
        int i;
        synchronized (c.class) {
            i = cjT;
            cjT = i + 1;
        }
        return i;
    }
}
