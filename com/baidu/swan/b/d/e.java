package com.baidu.swan.b.d;
/* loaded from: classes7.dex */
public class e {
    private static volatile d cjG;

    public static synchronized d ali() {
        d dVar;
        synchronized (e.class) {
            if (cjG == null) {
                cjG = new d();
            }
            dVar = cjG;
        }
        return dVar;
    }
}
