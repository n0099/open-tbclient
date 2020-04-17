package com.baidu.swan.bdprivate.invoice;
/* loaded from: classes7.dex */
public class g {
    private static volatile f cCT;

    public static synchronized f aqR() {
        f fVar;
        synchronized (g.class) {
            if (cCT == null) {
                cCT = new f();
            }
            fVar = cCT;
        }
        return fVar;
    }
}
