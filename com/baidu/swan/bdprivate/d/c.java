package com.baidu.swan.bdprivate.d;
/* loaded from: classes20.dex */
public class c {
    private static volatile b dPc;

    public static synchronized b aRg() {
        b bVar;
        synchronized (c.class) {
            if (dPc == null) {
                dPc = new b();
            }
            bVar = dPc;
        }
        return bVar;
    }
}
