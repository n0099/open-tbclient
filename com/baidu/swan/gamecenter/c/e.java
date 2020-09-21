package com.baidu.swan.gamecenter.c;
/* loaded from: classes19.dex */
public class e {
    private static volatile d dpQ;

    public static synchronized d aLr() {
        d dVar;
        synchronized (e.class) {
            if (dpQ == null) {
                dpQ = new d();
            }
            dVar = dpQ;
        }
        return dVar;
    }
}
