package com.baidu.swan.b.d;
/* loaded from: classes7.dex */
public class e {
    private static volatile d cIT;

    public static synchronized d atz() {
        d dVar;
        synchronized (e.class) {
            if (cIT == null) {
                cIT = new d();
            }
            dVar = cIT;
        }
        return dVar;
    }
}
