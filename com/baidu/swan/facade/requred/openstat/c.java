package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes20.dex */
public class c {
    private static volatile b dPC;

    public static synchronized b aRH() {
        b bVar;
        synchronized (c.class) {
            if (dPC == null) {
                dPC = new b();
            }
            bVar = dPC;
        }
        return bVar;
    }
}
