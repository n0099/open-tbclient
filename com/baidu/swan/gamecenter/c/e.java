package com.baidu.swan.gamecenter.c;
/* loaded from: classes20.dex */
public class e {
    private static volatile d dKr;

    public static synchronized d aPU() {
        d dVar;
        synchronized (e.class) {
            if (dKr == null) {
                dKr = new d();
            }
            dVar = dKr;
        }
        return dVar;
    }
}
