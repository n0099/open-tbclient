package com.baidu.swan.apps.t.a;
/* loaded from: classes20.dex */
public class d {
    private static volatile c cJB;

    public static synchronized c atB() {
        c cVar;
        synchronized (d.class) {
            if (cJB == null) {
                cJB = new c();
            }
            cVar = cJB;
        }
        return cVar;
    }
}
