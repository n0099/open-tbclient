package com.baidu.swan.bdprivate.b;
/* loaded from: classes19.dex */
public class c {
    private static volatile b dGm;

    public static synchronized b aNz() {
        b bVar;
        synchronized (c.class) {
            if (dGm == null) {
                dGm = new b();
            }
            bVar = dGm;
        }
        return bVar;
    }
}
