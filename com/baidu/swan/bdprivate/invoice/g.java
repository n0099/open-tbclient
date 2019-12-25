package com.baidu.swan.bdprivate.invoice;
/* loaded from: classes4.dex */
public class g {
    private static volatile f bZq;

    public static synchronized f afX() {
        f fVar;
        synchronized (g.class) {
            if (bZq == null) {
                bZq = new f();
            }
            fVar = bZq;
        }
        return fVar;
    }
}
