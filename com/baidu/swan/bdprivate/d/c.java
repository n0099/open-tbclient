package com.baidu.swan.bdprivate.d;
/* loaded from: classes19.dex */
public class c {
    private static volatile b dIe;

    public static synchronized b aOb() {
        b bVar;
        synchronized (c.class) {
            if (dIe == null) {
                dIe = new b();
            }
            bVar = dIe;
        }
        return bVar;
    }
}
