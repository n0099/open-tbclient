package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes7.dex */
public class e {
    private static volatile d dVR;

    public static synchronized d aQA() {
        d dVar;
        synchronized (e.class) {
            if (dVR == null) {
                dVR = new d();
            }
            dVar = dVR;
        }
        return dVar;
    }
}
