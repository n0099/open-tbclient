package com.baidu.swan.impl.map;
/* loaded from: classes20.dex */
public class e {
    private static volatile d eia;

    public static synchronized d bbI() {
        d dVar;
        synchronized (e.class) {
            if (eia == null) {
                eia = new d();
            }
            dVar = eia;
        }
        return dVar;
    }
}
