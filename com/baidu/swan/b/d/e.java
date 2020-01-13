package com.baidu.swan.b.d;
/* loaded from: classes5.dex */
public class e {
    private static volatile d cfB;

    public static synchronized d aiS() {
        d dVar;
        synchronized (e.class) {
            if (cfB == null) {
                cfB = new d();
            }
            dVar = cfB;
        }
        return dVar;
    }
}
