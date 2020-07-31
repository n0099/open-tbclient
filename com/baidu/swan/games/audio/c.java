package com.baidu.swan.games.audio;
/* loaded from: classes7.dex */
public class c {
    private static volatile int ddV;

    public static synchronized int aBY() {
        int i;
        synchronized (c.class) {
            i = ddV;
            ddV = i + 1;
        }
        return i;
    }
}
