package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes14.dex */
public class c {
    private static volatile b dhK;

    public static synchronized b aHx() {
        b bVar;
        synchronized (c.class) {
            if (dhK == null) {
                dhK = new b();
            }
            bVar = dhK;
        }
        return bVar;
    }
}
