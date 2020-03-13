package com.baidu.swan.bdprivate.invoice;
/* loaded from: classes7.dex */
public class g {
    private static volatile f cdK;

    public static synchronized f aiG() {
        f fVar;
        synchronized (g.class) {
            if (cdK == null) {
                cdK = new f();
            }
            fVar = cdK;
        }
        return fVar;
    }
}
