package com.baidu.swan.apps.t.a;
/* loaded from: classes6.dex */
public class d {
    private static volatile c ddi;

    public static synchronized c axT() {
        c cVar;
        synchronized (d.class) {
            if (ddi == null) {
                ddi = new c();
            }
            cVar = ddi;
        }
        return cVar;
    }
}
