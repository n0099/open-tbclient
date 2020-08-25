package com.baidu.swan.games.audio;
/* loaded from: classes8.dex */
public class c {
    private static volatile int doe;

    public static synchronized int aKN() {
        int i;
        synchronized (c.class) {
            i = doe;
            doe = i + 1;
        }
        return i;
    }
}
