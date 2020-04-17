package com.baidu.swan.b.d;
/* loaded from: classes7.dex */
public class e {
    private static volatile d cIN;

    public static synchronized d atz() {
        d dVar;
        synchronized (e.class) {
            if (cIN == null) {
                cIN = new d();
            }
            dVar = cIN;
        }
        return dVar;
    }
}
