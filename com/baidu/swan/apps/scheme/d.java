package com.baidu.swan.apps.scheme;
/* loaded from: classes6.dex */
public class d {
    private static volatile c dDS;

    public static synchronized c aJx() {
        c cVar;
        synchronized (d.class) {
            if (dDS == null) {
                dDS = new c();
            }
            cVar = dDS;
        }
        return cVar;
    }
}
