package com.baidu.swan.apps.scheme;
/* loaded from: classes5.dex */
public class d {
    private static volatile c bMv;

    public static synchronized c abs() {
        c cVar;
        synchronized (d.class) {
            if (bMv == null) {
                bMv = new c();
            }
            cVar = bMv;
        }
        return cVar;
    }
}
