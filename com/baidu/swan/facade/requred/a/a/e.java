package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes19.dex */
public class e {
    private static volatile d dID;

    public static synchronized d aOB() {
        d dVar;
        synchronized (e.class) {
            if (dID == null) {
                dID = new d();
            }
            dVar = dID;
        }
        return dVar;
    }
}
