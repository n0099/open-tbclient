package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes7.dex */
public class c {
    private static volatile b cTW;

    public static synchronized b awz() {
        b bVar;
        synchronized (c.class) {
            if (cTW == null) {
                cTW = new b();
            }
            bVar = cTW;
        }
        return bVar;
    }
}
