package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes20.dex */
public class c {
    private static volatile b dEu;

    public static synchronized b aMK() {
        b bVar;
        synchronized (c.class) {
            if (dEu == null) {
                dEu = new b();
            }
            bVar = dEu;
        }
        return bVar;
    }
}
