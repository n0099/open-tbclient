package com.baidu.swan.bdprivate.b;
/* loaded from: classes7.dex */
public class c {
    private static volatile b dWd;

    public static synchronized b aTa() {
        b bVar;
        synchronized (c.class) {
            if (dWd == null) {
                dWd = new b();
            }
            bVar = dWd;
        }
        return bVar;
    }
}
