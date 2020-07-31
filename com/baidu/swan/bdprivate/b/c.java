package com.baidu.swan.bdprivate.b;
/* loaded from: classes14.dex */
public class c {
    private static volatile b cWm;

    public static synchronized b aym() {
        b bVar;
        synchronized (c.class) {
            if (cWm == null) {
                cWm = new b();
            }
            bVar = cWm;
        }
        return bVar;
    }
}
