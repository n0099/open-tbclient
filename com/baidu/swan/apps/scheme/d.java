package com.baidu.swan.apps.scheme;
/* loaded from: classes2.dex */
public class d {
    private static volatile c aOU;

    public static synchronized c JG() {
        c cVar;
        synchronized (d.class) {
            if (aOU == null) {
                aOU = new c();
            }
            cVar = aOU;
        }
        return cVar;
    }
}
