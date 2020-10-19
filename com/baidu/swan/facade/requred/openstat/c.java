package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes20.dex */
public class c {
    private static volatile b dvX;

    public static synchronized b aKQ() {
        b bVar;
        synchronized (c.class) {
            if (dvX == null) {
                dvX = new b();
            }
            bVar = dvX;
        }
        return bVar;
    }
}
