package com.baidu.swan.apps.scheme;
/* loaded from: classes20.dex */
public class d {
    private static volatile c dzZ;

    public static synchronized c aLa() {
        c cVar;
        synchronized (d.class) {
            if (dzZ == null) {
                dzZ = new c();
            }
            cVar = dzZ;
        }
        return cVar;
    }
}
