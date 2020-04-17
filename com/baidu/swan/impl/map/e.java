package com.baidu.swan.impl.map;
/* loaded from: classes7.dex */
public class e {
    private static volatile d cUz;

    public static synchronized d azQ() {
        d dVar;
        synchronized (e.class) {
            if (cUz == null) {
                cUz = new d();
            }
            dVar = cUz;
        }
        return dVar;
    }
}
