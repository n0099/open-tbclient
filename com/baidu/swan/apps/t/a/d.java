package com.baidu.swan.apps.t.a;
/* loaded from: classes14.dex */
public class d {
    private static volatile c cvv;

    public static synchronized c aqf() {
        c cVar;
        synchronized (d.class) {
            if (cvv == null) {
                cvv = new c();
            }
            cVar = cvv;
        }
        return cVar;
    }
}
