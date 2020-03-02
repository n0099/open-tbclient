package com.baidu.swan.games.audio;
/* loaded from: classes11.dex */
public class c {
    private static volatile int cjH;

    public static synchronized int alj() {
        int i;
        synchronized (c.class) {
            i = cjH;
            cjH = i + 1;
        }
        return i;
    }
}
