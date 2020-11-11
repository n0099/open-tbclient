package com.baidu.swan.gamecenter.c;
/* loaded from: classes20.dex */
public class e {
    private static volatile d dQj;

    public static synchronized d aSu() {
        d dVar;
        synchronized (e.class) {
            if (dQj == null) {
                dQj = new d();
            }
            dVar = dQj;
        }
        return dVar;
    }
}
