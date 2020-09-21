package com.baidu.swan.impl.map;
/* loaded from: classes19.dex */
public class e {
    private static volatile d dCs;

    public static synchronized d aSh() {
        d dVar;
        synchronized (e.class) {
            if (dCs == null) {
                dCs = new d();
            }
            dVar = dCs;
        }
        return dVar;
    }
}
