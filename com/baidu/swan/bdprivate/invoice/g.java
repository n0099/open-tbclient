package com.baidu.swan.bdprivate.invoice;
/* loaded from: classes7.dex */
public class g {
    private static volatile f cdI;

    public static synchronized f aiE() {
        f fVar;
        synchronized (g.class) {
            if (cdI == null) {
                cdI = new f();
            }
            fVar = cdI;
        }
        return fVar;
    }
}
