package com.baidu.swan.bdprivate.d;
/* loaded from: classes14.dex */
public class c {
    private static volatile b dho;

    public static synchronized b aGW() {
        b bVar;
        synchronized (c.class) {
            if (dho == null) {
                dho = new b();
            }
            bVar = dho;
        }
        return bVar;
    }
}
