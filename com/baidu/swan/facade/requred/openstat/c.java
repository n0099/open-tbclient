package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes14.dex */
public class c {
    private static volatile b cYz;

    public static synchronized b azn() {
        b bVar;
        synchronized (c.class) {
            if (cYz == null) {
                cYz = new b();
            }
            bVar = cYz;
        }
        return bVar;
    }
}
