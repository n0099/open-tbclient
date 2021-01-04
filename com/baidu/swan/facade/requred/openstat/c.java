package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes7.dex */
public class c {
    private static volatile b dYy;

    public static synchronized b aUb() {
        b bVar;
        synchronized (c.class) {
            if (dYy == null) {
                dYy = new b();
            }
            bVar = dYy;
        }
        return bVar;
    }
}
