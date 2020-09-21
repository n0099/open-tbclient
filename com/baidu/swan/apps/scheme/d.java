package com.baidu.swan.apps.scheme;
/* loaded from: classes19.dex */
public class d {
    private static volatile c cUc;

    public static synchronized c aBx() {
        c cVar;
        synchronized (d.class) {
            if (cUc == null) {
                cUc = new c();
            }
            cVar = cUc;
        }
        return cVar;
    }
}
