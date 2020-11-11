package com.baidu.swan.apps.scheme;
/* loaded from: classes20.dex */
public class d {
    private static volatile c duH;

    public static synchronized c aIA() {
        c cVar;
        synchronized (d.class) {
            if (duH == null) {
                duH = new c();
            }
            cVar = duH;
        }
        return cVar;
    }
}
