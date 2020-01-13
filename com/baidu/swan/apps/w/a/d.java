package com.baidu.swan.apps.w.a;
/* loaded from: classes5.dex */
public class d {
    private static volatile c btN;

    public static synchronized c SQ() {
        c cVar;
        synchronized (d.class) {
            if (btN == null) {
                btN = new c();
            }
            cVar = btN;
        }
        return cVar;
    }
}
