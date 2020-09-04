package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes14.dex */
public class e {
    private static volatile d dhN;

    public static synchronized d aHw() {
        d dVar;
        synchronized (e.class) {
            if (dhN == null) {
                dhN = new d();
            }
            dVar = dhN;
        }
        return dVar;
    }
}
