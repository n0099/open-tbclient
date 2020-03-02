package com.baidu.swan.bdprivate.invoice;
/* loaded from: classes7.dex */
public class g {
    private static volatile f cdJ;

    public static synchronized f aiG() {
        f fVar;
        synchronized (g.class) {
            if (cdJ == null) {
                cdJ = new f();
            }
            fVar = cdJ;
        }
        return fVar;
    }
}
