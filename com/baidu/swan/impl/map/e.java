package com.baidu.swan.impl.map;
/* loaded from: classes7.dex */
public class e {
    private static volatile d cvD;

    public static synchronized d arF() {
        d dVar;
        synchronized (e.class) {
            if (cvD == null) {
                cvD = new d();
            }
            dVar = cvD;
        }
        return dVar;
    }
}
