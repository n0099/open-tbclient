package com.baidu.swan.games.audio;
/* loaded from: classes11.dex */
public class c {
    private static volatile int cIO;

    public static synchronized int atA() {
        int i;
        synchronized (c.class) {
            i = cIO;
            cIO = i + 1;
        }
        return i;
    }
}
