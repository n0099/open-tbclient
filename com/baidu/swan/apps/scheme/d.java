package com.baidu.swan.apps.scheme;
/* loaded from: classes20.dex */
public class d {
    private static volatile c dgk;

    public static synchronized c aEg() {
        c cVar;
        synchronized (d.class) {
            if (dgk == null) {
                dgk = new c();
            }
            cVar = dgk;
        }
        return cVar;
    }
}
