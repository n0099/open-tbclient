package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes19.dex */
public class e {
    private static volatile d djQ;

    public static synchronized d aIg() {
        d dVar;
        synchronized (e.class) {
            if (djQ == null) {
                djQ = new d();
            }
            dVar = djQ;
        }
        return dVar;
    }
}
