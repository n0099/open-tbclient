package com.baidu.swan.b.d;
/* loaded from: classes7.dex */
public class e {
    private static volatile d cXS;

    public static synchronized d aym() {
        d dVar;
        synchronized (e.class) {
            if (cXS == null) {
                cXS = new d();
            }
            dVar = cXS;
        }
        return dVar;
    }
}
