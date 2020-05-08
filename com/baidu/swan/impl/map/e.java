package com.baidu.swan.impl.map;
/* loaded from: classes7.dex */
public class e {
    private static volatile d cUE;

    public static synchronized d azQ() {
        d dVar;
        synchronized (e.class) {
            if (cUE == null) {
                cUE = new d();
            }
            dVar = cUE;
        }
        return dVar;
    }
}
