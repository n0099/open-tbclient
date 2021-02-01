package com.baidu.swan.bdprivate.b;
/* loaded from: classes7.dex */
public class c {
    private static volatile b dTx;

    public static synchronized b aPA() {
        b bVar;
        synchronized (c.class) {
            if (dTx == null) {
                dTx = new b();
            }
            bVar = dTx;
        }
        return bVar;
    }
}
