package com.baidu.swan.bdprivate.d;
/* loaded from: classes6.dex */
public class c {
    private static volatile b dTi;

    public static synchronized b aPI() {
        b bVar;
        synchronized (c.class) {
            if (dTi == null) {
                dTi = new b();
            }
            bVar = dTi;
        }
        return bVar;
    }
}
