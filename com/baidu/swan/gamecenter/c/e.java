package com.baidu.swan.gamecenter.c;
/* loaded from: classes14.dex */
public class e {
    private static volatile d dnO;

    public static synchronized d aKG() {
        d dVar;
        synchronized (e.class) {
            if (dnO == null) {
                dnO = new d();
            }
            dVar = dnO;
        }
        return dVar;
    }
}
