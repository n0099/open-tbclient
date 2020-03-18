package com.baidu.swan.b.d;
/* loaded from: classes7.dex */
public class e {
    private static volatile d cjS;

    public static synchronized d all() {
        d dVar;
        synchronized (e.class) {
            if (cjS == null) {
                cjS = new d();
            }
            dVar = cjS;
        }
        return dVar;
    }
}
