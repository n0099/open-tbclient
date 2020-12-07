package com.baidu.swan.bdprivate.b;
/* loaded from: classes20.dex */
public class c {
    private static volatile b dNk;

    public static synchronized b aQF() {
        b bVar;
        synchronized (c.class) {
            if (dNk == null) {
                dNk = new b();
            }
            bVar = dNk;
        }
        return bVar;
    }
}
