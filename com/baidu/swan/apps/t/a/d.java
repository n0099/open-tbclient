package com.baidu.swan.apps.t.a;
/* loaded from: classes20.dex */
public class d {
    private static volatile c cRX;

    public static synchronized c avv() {
        c cVar;
        synchronized (d.class) {
            if (cRX == null) {
                cRX = new c();
            }
            cVar = cRX;
        }
        return cVar;
    }
}
