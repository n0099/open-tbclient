package com.baidu.swan.gamecenter.c;
/* loaded from: classes6.dex */
public class e {
    private static volatile d dZK;

    public static synchronized d aTs() {
        d dVar;
        synchronized (e.class) {
            if (dZK == null) {
                dZK = new d();
            }
            dVar = dZK;
        }
        return dVar;
    }
}
