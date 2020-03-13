package com.baidu.swan.b.d;
/* loaded from: classes7.dex */
public class e {
    private static volatile d cjH;

    public static synchronized d ali() {
        d dVar;
        synchronized (e.class) {
            if (cjH == null) {
                cjH = new d();
            }
            dVar = cjH;
        }
        return dVar;
    }
}
