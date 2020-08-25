package com.baidu.swan.gamecenter.c;
/* loaded from: classes14.dex */
public class e {
    private static volatile d dnK;

    public static synchronized d aKG() {
        d dVar;
        synchronized (e.class) {
            if (dnK == null) {
                dnK = new d();
            }
            dVar = dnK;
        }
        return dVar;
    }
}
