package com.baidu.swan.apps.scheme;
/* loaded from: classes2.dex */
public class d {
    private static volatile c aOY;

    public static synchronized c JE() {
        c cVar;
        synchronized (d.class) {
            if (aOY == null) {
                aOY = new c();
            }
            cVar = aOY;
        }
        return cVar;
    }
}
