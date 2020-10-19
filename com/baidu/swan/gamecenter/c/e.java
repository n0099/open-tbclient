package com.baidu.swan.gamecenter.c;
/* loaded from: classes20.dex */
public class e {
    private static volatile d dBU;

    public static synchronized d aOa() {
        d dVar;
        synchronized (e.class) {
            if (dBU == null) {
                dBU = new d();
            }
            dVar = dBU;
        }
        return dVar;
    }
}
