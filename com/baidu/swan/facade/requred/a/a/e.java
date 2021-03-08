package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes6.dex */
public class e {
    private static volatile d dXs;

    public static synchronized d aQD() {
        d dVar;
        synchronized (e.class) {
            if (dXs == null) {
                dXs = new d();
            }
            dVar = dXs;
        }
        return dVar;
    }
}
