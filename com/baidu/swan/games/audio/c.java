package com.baidu.swan.games.audio;
/* loaded from: classes3.dex */
public class c {
    private static volatile int dqj;

    public static synchronized int aLy() {
        int i;
        synchronized (c.class) {
            i = dqj;
            dqj = i + 1;
        }
        return i;
    }
}
