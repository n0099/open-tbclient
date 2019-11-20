package com.baidu.swan.games.audio;
/* loaded from: classes2.dex */
public class c {
    private static volatile int bxf;

    public static synchronized int VG() {
        int i;
        synchronized (c.class) {
            i = bxf;
            bxf = i + 1;
        }
        return i;
    }
}
