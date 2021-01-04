package com.baidu.swan.bdprivate.d;
/* loaded from: classes7.dex */
public class c {
    private static volatile b dXU;

    public static synchronized b aTB() {
        b bVar;
        synchronized (c.class) {
            if (dXU == null) {
                dXU = new b();
            }
            bVar = dXU;
        }
        return bVar;
    }
}
