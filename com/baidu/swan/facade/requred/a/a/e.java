package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes7.dex */
public class e {
    private static volatile d dYx;

    public static synchronized d aUa() {
        d dVar;
        synchronized (e.class) {
            if (dYx == null) {
                dYx = new d();
            }
            dVar = dYx;
        }
        return dVar;
    }
}
