package com.baidu.swan.b.d;
/* loaded from: classes7.dex */
public class e {
    private static volatile d cTi;

    public static synchronized d axg() {
        d dVar;
        synchronized (e.class) {
            if (cTi == null) {
                cTi = new d();
            }
            dVar = cTi;
        }
        return dVar;
    }
}
