package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes19.dex */
public class c {
    private static volatile b djR;

    public static synchronized b aIh() {
        b bVar;
        synchronized (c.class) {
            if (djR == null) {
                djR = new b();
            }
            bVar = djR;
        }
        return bVar;
    }
}
