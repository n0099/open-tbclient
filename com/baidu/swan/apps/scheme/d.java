package com.baidu.swan.apps.scheme;
/* loaded from: classes20.dex */
public class d {
    private static volatile c doM;

    public static synchronized c aGa() {
        c cVar;
        synchronized (d.class) {
            if (doM == null) {
                doM = new c();
            }
            cVar = doM;
        }
        return cVar;
    }
}
