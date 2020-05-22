package com.baidu.swan.impl.map;
/* loaded from: classes7.dex */
public class e {
    private static volatile d dfF;

    public static synchronized d aDI() {
        d dVar;
        synchronized (e.class) {
            if (dfF == null) {
                dfF = new d();
            }
            dVar = dfF;
        }
        return dVar;
    }
}
