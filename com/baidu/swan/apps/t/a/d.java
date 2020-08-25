package com.baidu.swan.apps.t.a;
/* loaded from: classes14.dex */
public class d {
    private static volatile c cvr;

    public static synchronized c aqf() {
        c cVar;
        synchronized (d.class) {
            if (cvr == null) {
                cvr = new c();
            }
            cVar = cvr;
        }
        return cVar;
    }
}
