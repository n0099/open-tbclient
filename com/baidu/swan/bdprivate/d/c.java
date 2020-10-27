package com.baidu.swan.bdprivate.d;
/* loaded from: classes20.dex */
public class c {
    private static volatile b dDU;

    public static synchronized b aMj() {
        b bVar;
        synchronized (c.class) {
            if (dDU == null) {
                dDU = new b();
            }
            bVar = dDU;
        }
        return bVar;
    }
}
