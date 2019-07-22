package com.baidu.swan.apps.scheme;
/* loaded from: classes2.dex */
public class d {
    private static volatile c aRM;

    public static synchronized c MN() {
        c cVar;
        synchronized (d.class) {
            if (aRM == null) {
                aRM = new c();
            }
            cVar = aRM;
        }
        return cVar;
    }
}
