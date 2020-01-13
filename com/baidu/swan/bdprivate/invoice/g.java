package com.baidu.swan.bdprivate.invoice;
/* loaded from: classes5.dex */
public class g {
    private static volatile f bZC;

    public static synchronized f agq() {
        f fVar;
        synchronized (g.class) {
            if (bZC == null) {
                bZC = new f();
            }
            fVar = bZC;
        }
        return fVar;
    }
}
