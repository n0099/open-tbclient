package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes6.dex */
public class e {
    private static volatile d dTL;

    public static synchronized d aQh() {
        d dVar;
        synchronized (e.class) {
            if (dTL == null) {
                dTL = new d();
            }
            dVar = dTL;
        }
        return dVar;
    }
}
