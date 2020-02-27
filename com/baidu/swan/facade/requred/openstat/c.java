package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes7.dex */
public class c {
    private static volatile b cfL;

    public static synchronized b ajy() {
        b bVar;
        synchronized (c.class) {
            if (cfL == null) {
                cfL = new b();
            }
            bVar = cfL;
        }
        return bVar;
    }
}
