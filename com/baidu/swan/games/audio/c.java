package com.baidu.swan.games.audio;
/* loaded from: classes11.dex */
public class c {
    private static volatile int cYl;

    public static synchronized int ayt() {
        int i;
        synchronized (c.class) {
            i = cYl;
            cYl = i + 1;
        }
        return i;
    }
}
