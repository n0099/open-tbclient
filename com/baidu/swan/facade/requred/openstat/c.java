package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes7.dex */
public class c {
    private static volatile b dVS;

    public static synchronized b aQB() {
        b bVar;
        synchronized (c.class) {
            if (dVS == null) {
                dVS = new b();
            }
            bVar = dVS;
        }
        return bVar;
    }
}
