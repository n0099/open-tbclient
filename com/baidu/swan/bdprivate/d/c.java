package com.baidu.swan.bdprivate.d;
/* loaded from: classes14.dex */
public class c {
    private static volatile b dhk;

    public static synchronized b aGW() {
        b bVar;
        synchronized (c.class) {
            if (dhk == null) {
                dhk = new b();
            }
            bVar = dhk;
        }
        return bVar;
    }
}
