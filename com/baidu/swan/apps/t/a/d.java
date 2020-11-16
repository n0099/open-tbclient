package com.baidu.swan.apps.t.a;
/* loaded from: classes19.dex */
public class d {
    private static volatile c cWg;

    public static synchronized c axn() {
        c cVar;
        synchronized (d.class) {
            if (cWg == null) {
                cWg = new c();
            }
            cVar = cWg;
        }
        return cVar;
    }
}
