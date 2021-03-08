package com.baidu.swan.bdprivate.b;
/* loaded from: classes6.dex */
public class c {
    private static volatile b dUY;

    public static synchronized b aPD() {
        b bVar;
        synchronized (c.class) {
            if (dUY == null) {
                dUY = new b();
            }
            bVar = dUY;
        }
        return bVar;
    }
}
