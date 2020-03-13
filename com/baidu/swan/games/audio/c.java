package com.baidu.swan.games.audio;
/* loaded from: classes11.dex */
public class c {
    private static volatile int cjI;

    public static synchronized int alj() {
        int i;
        synchronized (c.class) {
            i = cjI;
            cjI = i + 1;
        }
        return i;
    }
}
