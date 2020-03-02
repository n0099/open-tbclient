package com.baidu.swan.apps.scheme;
/* loaded from: classes7.dex */
public class d {
    private static volatile c bQB;

    public static synchronized c adI() {
        c cVar;
        synchronized (d.class) {
            if (bQB == null) {
                bQB = new c();
            }
            cVar = bQB;
        }
        return cVar;
    }
}
