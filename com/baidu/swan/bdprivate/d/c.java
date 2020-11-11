package com.baidu.swan.bdprivate.d;
/* loaded from: classes20.dex */
public class c {
    private static volatile b dJM;

    public static synchronized b aOJ() {
        b bVar;
        synchronized (c.class) {
            if (dJM == null) {
                dJM = new b();
            }
            bVar = dJM;
        }
        return bVar;
    }
}
