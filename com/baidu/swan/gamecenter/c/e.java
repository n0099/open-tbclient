package com.baidu.swan.gamecenter.c;
/* loaded from: classes14.dex */
public class e {
    private static volatile d ddC;

    public static synchronized d aBR() {
        d dVar;
        synchronized (e.class) {
            if (ddC == null) {
                ddC = new d();
            }
            dVar = ddC;
        }
        return dVar;
    }
}
