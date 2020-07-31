package com.baidu.swan.impl.map;
/* loaded from: classes14.dex */
public class e {
    private static volatile d dql;

    public static synchronized d aIF() {
        d dVar;
        synchronized (e.class) {
            if (dql == null) {
                dql = new d();
            }
            dVar = dql;
        }
        return dVar;
    }
}
