package com.baidu.swan.bdprivate.b;
/* loaded from: classes20.dex */
public class c {
    private static volatile b dHU;

    public static synchronized b aOh() {
        b bVar;
        synchronized (c.class) {
            if (dHU == null) {
                dHU = new b();
            }
            bVar = dHU;
        }
        return bVar;
    }
}
