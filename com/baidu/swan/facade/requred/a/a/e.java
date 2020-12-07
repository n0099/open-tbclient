package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes20.dex */
public class e {
    private static volatile d dPB;

    public static synchronized d aRG() {
        d dVar;
        synchronized (e.class) {
            if (dPB == null) {
                dPB = new d();
            }
            dVar = dPB;
        }
        return dVar;
    }
}
