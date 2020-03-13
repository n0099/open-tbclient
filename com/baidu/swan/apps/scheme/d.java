package com.baidu.swan.apps.scheme;
/* loaded from: classes7.dex */
public class d {
    private static volatile c bQC;

    public static synchronized c adI() {
        c cVar;
        synchronized (d.class) {
            if (bQC == null) {
                bQC = new c();
            }
            cVar = bQC;
        }
        return cVar;
    }
}
