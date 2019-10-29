package com.baidu.swan.games.audio;
/* loaded from: classes2.dex */
public class c {
    private static volatile int bxW;

    public static synchronized int VI() {
        int i;
        synchronized (c.class) {
            i = bxW;
            bxW = i + 1;
        }
        return i;
    }
}
