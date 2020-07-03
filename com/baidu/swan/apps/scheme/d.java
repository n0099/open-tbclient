package com.baidu.swan.apps.scheme;
/* loaded from: classes7.dex */
public class d {
    private static volatile c cGg;

    public static synchronized c aqT() {
        c cVar;
        synchronized (d.class) {
            if (cGg == null) {
                cGg = new c();
            }
            cVar = cGg;
        }
        return cVar;
    }
}
