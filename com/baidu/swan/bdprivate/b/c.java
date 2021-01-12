package com.baidu.swan.bdprivate.b;
/* loaded from: classes6.dex */
public class c {
    private static volatile b dRr;

    public static synchronized b aPh() {
        b bVar;
        synchronized (c.class) {
            if (dRr == null) {
                dRr = new b();
            }
            bVar = dRr;
        }
        return bVar;
    }
}
