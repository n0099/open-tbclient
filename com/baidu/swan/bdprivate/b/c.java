package com.baidu.swan.bdprivate.b;
/* loaded from: classes20.dex */
public class c {
    private static volatile b dtF;

    public static synchronized b aJN() {
        b bVar;
        synchronized (c.class) {
            if (dtF == null) {
                dtF = new b();
            }
            bVar = dtF;
        }
        return bVar;
    }
}
