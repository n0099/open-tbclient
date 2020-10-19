package com.baidu.swan.impl.map;
/* loaded from: classes20.dex */
public class e {
    private static volatile d dOt;

    public static synchronized d aUQ() {
        d dVar;
        synchronized (e.class) {
            if (dOt == null) {
                dOt = new d();
            }
            dVar = dOt;
        }
        return dVar;
    }
}
