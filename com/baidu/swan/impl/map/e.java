package com.baidu.swan.impl.map;
/* loaded from: classes14.dex */
public class e {
    private static volatile d dAr;

    public static synchronized d aRv() {
        d dVar;
        synchronized (e.class) {
            if (dAr == null) {
                dAr = new d();
            }
            dVar = dAr;
        }
        return dVar;
    }
}
