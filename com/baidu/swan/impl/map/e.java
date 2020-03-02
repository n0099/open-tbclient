package com.baidu.swan.impl.map;
/* loaded from: classes7.dex */
public class e {
    private static volatile d cvr;

    public static synchronized d arC() {
        d dVar;
        synchronized (e.class) {
            if (cvr == null) {
                cvr = new d();
            }
            dVar = cvr;
        }
        return dVar;
    }
}
