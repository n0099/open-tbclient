package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes7.dex */
public class c {
    private static volatile b cPm;

    public static synchronized b avt() {
        b bVar;
        synchronized (c.class) {
            if (cPm == null) {
                cPm = new b();
            }
            bVar = cPm;
        }
        return bVar;
    }
}
