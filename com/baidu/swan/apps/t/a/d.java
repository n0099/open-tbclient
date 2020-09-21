package com.baidu.swan.apps.t.a;
/* loaded from: classes19.dex */
public class d {
    private static volatile c cxw;

    public static synchronized c aqP() {
        c cVar;
        synchronized (d.class) {
            if (cxw == null) {
                cxw = new c();
            }
            cVar = cxw;
        }
        return cVar;
    }
}
