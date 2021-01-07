package com.baidu.swan.apps.t.a;
/* loaded from: classes7.dex */
public class d {
    private static volatile c dhW;

    public static synchronized c aBN() {
        c cVar;
        synchronized (d.class) {
            if (dhW == null) {
                dhW = new c();
            }
            cVar = dhW;
        }
        return cVar;
    }
}
