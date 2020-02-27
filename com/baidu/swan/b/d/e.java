package com.baidu.swan.b.d;
/* loaded from: classes7.dex */
public class e {
    private static volatile d cjF;

    public static synchronized d alg() {
        d dVar;
        synchronized (e.class) {
            if (cjF == null) {
                cjF = new d();
            }
            dVar = cjF;
        }
        return dVar;
    }
}
