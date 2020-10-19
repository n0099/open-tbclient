package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes20.dex */
public class e {
    private static volatile d dvW;

    public static synchronized d aKP() {
        d dVar;
        synchronized (e.class) {
            if (dvW == null) {
                dvW = new d();
            }
            dVar = dvW;
        }
        return dVar;
    }
}
