package com.baidu.swan.apps.scheme;
/* loaded from: classes7.dex */
public class d {
    private static volatile c dIE;

    public static synchronized c aNq() {
        c cVar;
        synchronized (d.class) {
            if (dIE == null) {
                dIE = new c();
            }
            cVar = dIE;
        }
        return cVar;
    }
}
