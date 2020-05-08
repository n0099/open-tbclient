package com.baidu.swan.bdprivate.invoice;
/* loaded from: classes7.dex */
public class g {
    private static volatile f cCZ;

    public static synchronized f aqQ() {
        f fVar;
        synchronized (g.class) {
            if (cCZ == null) {
                cCZ = new f();
            }
            fVar = cCZ;
        }
        return fVar;
    }
}
