package com.baidu.swan.apps.t.a;
/* loaded from: classes20.dex */
public class d {
    private static volatile c cXQ;

    public static synchronized c axV() {
        c cVar;
        synchronized (d.class) {
            if (cXQ == null) {
                cXQ = new c();
            }
            cVar = cXQ;
        }
        return cVar;
    }
}
