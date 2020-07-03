package com.baidu.swan.impl.map;
/* loaded from: classes7.dex */
public class e {
    private static volatile d dkr;

    public static synchronized d aEO() {
        d dVar;
        synchronized (e.class) {
            if (dkr == null) {
                dkr = new d();
            }
            dVar = dkr;
        }
        return dVar;
    }
}
