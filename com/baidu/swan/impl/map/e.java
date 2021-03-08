package com.baidu.swan.impl.map;
/* loaded from: classes6.dex */
public class e {
    private static volatile d epZ;

    public static synchronized d bax() {
        d dVar;
        synchronized (e.class) {
            if (epZ == null) {
                epZ = new d();
            }
            dVar = epZ;
        }
        return dVar;
    }
}
