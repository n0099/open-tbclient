package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes7.dex */
public class c {
    private static volatile b cEW;

    public static synchronized b arL() {
        b bVar;
        synchronized (c.class) {
            if (cEW == null) {
                cEW = new b();
            }
            bVar = cEW;
        }
        return bVar;
    }
}
