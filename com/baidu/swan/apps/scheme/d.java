package com.baidu.swan.apps.scheme;
/* loaded from: classes2.dex */
public class d {
    private static volatile c blo;

    public static synchronized c RJ() {
        c cVar;
        synchronized (d.class) {
            if (blo == null) {
                blo = new c();
            }
            cVar = blo;
        }
        return cVar;
    }
}
