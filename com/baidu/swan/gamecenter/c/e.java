package com.baidu.swan.gamecenter.c;
/* loaded from: classes7.dex */
public class e {
    private static volatile d eew;

    public static synchronized d aXm() {
        d dVar;
        synchronized (e.class) {
            if (eew == null) {
                eew = new d();
            }
            dVar = eew;
        }
        return dVar;
    }
}
