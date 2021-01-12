package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes6.dex */
public class c {
    private static volatile b dTM;

    public static synchronized b aQi() {
        b bVar;
        synchronized (c.class) {
            if (dTM == null) {
                dTM = new b();
            }
            bVar = dTM;
        }
        return bVar;
    }
}
