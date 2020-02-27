package com.baidu.swan.games.audio;
/* loaded from: classes11.dex */
public class c {
    private static volatile int cjG;

    public static synchronized int alh() {
        int i;
        synchronized (c.class) {
            i = cjG;
            cjG = i + 1;
        }
        return i;
    }
}
