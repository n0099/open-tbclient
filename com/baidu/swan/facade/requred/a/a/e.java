package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes20.dex */
public class e {
    private static volatile d dEt;

    public static synchronized d aMJ() {
        d dVar;
        synchronized (e.class) {
            if (dEt == null) {
                dEt = new d();
            }
            dVar = dEt;
        }
        return dVar;
    }
}
