package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes6.dex */
public class c {
    private static volatile b dXt;

    public static synchronized b aQE() {
        b bVar;
        synchronized (c.class) {
            if (dXt == null) {
                dXt = new b();
            }
            bVar = dXt;
        }
        return bVar;
    }
}
