package com.baidu.swan.apps.scheme;
/* loaded from: classes2.dex */
public class d {
    private static volatile c aOT;

    public static synchronized c JG() {
        c cVar;
        synchronized (d.class) {
            if (aOT == null) {
                aOT = new c();
            }
            cVar = aOT;
        }
        return cVar;
    }
}
