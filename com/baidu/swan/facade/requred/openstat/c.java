package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes20.dex */
public class c {
    private static volatile b dKm;

    public static synchronized b aPk() {
        b bVar;
        synchronized (c.class) {
            if (dKm == null) {
                dKm = new b();
            }
            bVar = dKm;
        }
        return bVar;
    }
}
