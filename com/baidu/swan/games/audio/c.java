package com.baidu.swan.games.audio;
/* loaded from: classes7.dex */
public class c {
    private static volatile int dOU;

    public static synchronized int aRT() {
        int i;
        synchronized (c.class) {
            i = dOU;
            dOU = i + 1;
        }
        return i;
    }
}
