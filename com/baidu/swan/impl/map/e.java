package com.baidu.swan.impl.map;
/* loaded from: classes19.dex */
public class e {
    private static volatile d eaZ;

    public static synchronized d aYD() {
        d dVar;
        synchronized (e.class) {
            if (eaZ == null) {
                eaZ = new d();
            }
            dVar = eaZ;
        }
        return dVar;
    }
}
