package com.baidu.swan.gamecenter.c;
/* loaded from: classes20.dex */
public class e {
    private static volatile d dVz;

    public static synchronized d aUR() {
        d dVar;
        synchronized (e.class) {
            if (dVz == null) {
                dVz = new d();
            }
            dVar = dVz;
        }
        return dVar;
    }
}
