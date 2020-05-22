package com.baidu.swan.bdprivate.b;
/* loaded from: classes7.dex */
public class c {
    private static volatile b cNL;

    public static synchronized b auN() {
        b bVar;
        synchronized (c.class) {
            if (cNL == null) {
                cNL = new b();
            }
            bVar = cNL;
        }
        return bVar;
    }
}
