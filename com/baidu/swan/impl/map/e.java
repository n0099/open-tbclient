package com.baidu.swan.impl.map;
/* loaded from: classes20.dex */
public class e {
    private static volatile d dWQ;

    public static synchronized d aWK() {
        d dVar;
        synchronized (e.class) {
            if (dWQ == null) {
                dWQ = new d();
            }
            dVar = dWQ;
        }
        return dVar;
    }
}
