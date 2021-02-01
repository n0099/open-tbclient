package com.baidu.swan.apps.scheme;
/* loaded from: classes7.dex */
public class d {
    private static volatile c dFW;

    public static synchronized c aJQ() {
        c cVar;
        synchronized (d.class) {
            if (dFW == null) {
                dFW = new c();
            }
            cVar = dFW;
        }
        return cVar;
    }
}
