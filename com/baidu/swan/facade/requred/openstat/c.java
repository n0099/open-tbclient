package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes4.dex */
public class c {
    private static volatile b cbu;

    public static synchronized b agR() {
        b bVar;
        synchronized (c.class) {
            if (cbu == null) {
                cbu = new b();
            }
            bVar = cbu;
        }
        return bVar;
    }
}
