package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes7.dex */
public class c {
    private static volatile b cfY;

    public static synchronized b ajD() {
        b bVar;
        synchronized (c.class) {
            if (cfY == null) {
                cfY = new b();
            }
            bVar = cfY;
        }
        return bVar;
    }
}
