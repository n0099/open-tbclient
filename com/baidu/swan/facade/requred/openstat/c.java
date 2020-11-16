package com.baidu.swan.facade.requred.openstat;
/* loaded from: classes19.dex */
public class c {
    private static volatile b dIE;

    public static synchronized b aOC() {
        b bVar;
        synchronized (c.class) {
            if (dIE == null) {
                dIE = new b();
            }
            bVar = dIE;
        }
        return bVar;
    }
}
