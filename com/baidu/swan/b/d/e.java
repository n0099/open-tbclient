package com.baidu.swan.b.d;
/* loaded from: classes4.dex */
public class e {
    private static volatile d cfo;

    public static synchronized d aiz() {
        d dVar;
        synchronized (e.class) {
            if (cfo == null) {
                cfo = new d();
            }
            dVar = cfo;
        }
        return dVar;
    }
}
