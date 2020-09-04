package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes14.dex */
public class c {
    private static volatile b dhO;

    public static synchronized b aHx() {
        b bVar;
        synchronized (c.class) {
            if (dhO == null) {
                dhO = new b();
            }
            bVar = dhO;
        }
        return bVar;
    }
}
