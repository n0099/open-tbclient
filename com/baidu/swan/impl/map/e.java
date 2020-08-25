package com.baidu.swan.impl.map;
/* loaded from: classes14.dex */
public class e {
    private static volatile d dAn;

    public static synchronized d aRv() {
        d dVar;
        synchronized (e.class) {
            if (dAn == null) {
                dAn = new d();
            }
            dVar = dAn;
        }
        return dVar;
    }
}
