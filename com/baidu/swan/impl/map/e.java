package com.baidu.swan.impl.map;
/* loaded from: classes7.dex */
public class e {
    private static volatile d cvq;

    public static synchronized d arA() {
        d dVar;
        synchronized (e.class) {
            if (cvq == null) {
                cvq = new d();
            }
            dVar = cvq;
        }
        return dVar;
    }
}
