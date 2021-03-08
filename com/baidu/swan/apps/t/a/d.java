package com.baidu.swan.apps.t.a;
/* loaded from: classes6.dex */
public class d {
    private static volatile c dgW;

    public static synchronized c ayu() {
        c cVar;
        synchronized (d.class) {
            if (dgW == null) {
                dgW = new c();
            }
            cVar = dgW;
        }
        return cVar;
    }
}
