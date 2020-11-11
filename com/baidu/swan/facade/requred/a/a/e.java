package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes20.dex */
public class e {
    private static volatile d dKl;

    public static synchronized d aPj() {
        d dVar;
        synchronized (e.class) {
            if (dKl == null) {
                dKl = new d();
            }
            dVar = dKl;
        }
        return dVar;
    }
}
