package com.baidu.swan.bdprivate.d;
/* loaded from: classes14.dex */
public class c {
    private static volatile b cYc;

    public static synchronized b ayN() {
        b bVar;
        synchronized (c.class) {
            if (cYc == null) {
                cYc = new b();
            }
            bVar = cYc;
        }
        return bVar;
    }
}
