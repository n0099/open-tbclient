package com.baidu.swan.apps.t.a;
/* loaded from: classes20.dex */
public class d {
    private static volatile c ddd;

    public static synchronized c aAv() {
        c cVar;
        synchronized (d.class) {
            if (ddd == null) {
                ddd = new c();
            }
            cVar = ddd;
        }
        return cVar;
    }
}
