package com.baidu.swan.bdprivate.b;
/* loaded from: classes20.dex */
public class c {
    private static volatile b dCc;

    public static synchronized b aLH() {
        b bVar;
        synchronized (c.class) {
            if (dCc == null) {
                dCc = new b();
            }
            bVar = dCc;
        }
        return bVar;
    }
}
