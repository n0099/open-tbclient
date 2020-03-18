package com.baidu.swan.bdprivate.invoice;
/* loaded from: classes7.dex */
public class g {
    private static volatile f cdV;

    public static synchronized f aiJ() {
        f fVar;
        synchronized (g.class) {
            if (cdV == null) {
                cdV = new f();
            }
            fVar = cdV;
        }
        return fVar;
    }
}
