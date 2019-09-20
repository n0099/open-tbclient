package com.baidu.swan.games.audio;
/* loaded from: classes2.dex */
public class c {
    private static volatile int bfd;

    public static synchronized int QS() {
        int i;
        synchronized (c.class) {
            i = bfd;
            bfd = i + 1;
        }
        return i;
    }
}
