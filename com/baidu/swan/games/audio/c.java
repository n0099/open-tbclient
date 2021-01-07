package com.baidu.swan.games.audio;
/* loaded from: classes9.dex */
public class c {
    private static volatile int eeP;

    public static synchronized int aXt() {
        int i;
        synchronized (c.class) {
            i = eeP;
            eeP = i + 1;
        }
        return i;
    }
}
