package com.baidu.swan.apps.scheme;
/* loaded from: classes6.dex */
public class d {
    private static volatile c dHx;

    public static synchronized c aJT() {
        c cVar;
        synchronized (d.class) {
            if (dHx == null) {
                dHx = new c();
            }
            cVar = dHx;
        }
        return cVar;
    }
}
