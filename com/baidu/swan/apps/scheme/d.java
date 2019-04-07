package com.baidu.swan.apps.scheme;
/* loaded from: classes2.dex */
public class d {
    private static volatile c aOX;

    public static synchronized c JE() {
        c cVar;
        synchronized (d.class) {
            if (aOX == null) {
                aOX = new c();
            }
            cVar = aOX;
        }
        return cVar;
    }
}
