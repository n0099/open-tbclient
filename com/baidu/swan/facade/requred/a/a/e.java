package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes14.dex */
public class e {
    private static volatile d dhJ;

    public static synchronized d aHw() {
        d dVar;
        synchronized (e.class) {
            if (dhJ == null) {
                dhJ = new d();
            }
            dVar = dhJ;
        }
        return dVar;
    }
}
