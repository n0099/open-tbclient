package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes7.dex */
public class c {
    private static volatile b cFc;

    public static synchronized b arK() {
        b bVar;
        synchronized (c.class) {
            if (cFc == null) {
                cFc = new b();
            }
            bVar = cFc;
        }
        return bVar;
    }
}
