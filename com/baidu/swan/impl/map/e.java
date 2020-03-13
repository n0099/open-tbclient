package com.baidu.swan.impl.map;
/* loaded from: classes7.dex */
public class e {
    private static volatile d cvs;

    public static synchronized d arC() {
        d dVar;
        synchronized (e.class) {
            if (cvs == null) {
                cvs = new d();
            }
            dVar = cvs;
        }
        return dVar;
    }
}
