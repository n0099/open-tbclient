package com.baidu.swan.facade.requred.a.a;
/* loaded from: classes6.dex */
public class b {
    private static volatile a dXr;

    public static synchronized a aQC() {
        a aVar;
        synchronized (b.class) {
            if (dXr == null) {
                dXr = new a();
            }
            aVar = dXr;
        }
        return aVar;
    }
}
