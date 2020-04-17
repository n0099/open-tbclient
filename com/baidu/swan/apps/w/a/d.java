package com.baidu.swan.apps.w.a;
/* loaded from: classes7.dex */
public class d {
    private static volatile c bWq;

    public static synchronized c acY() {
        c cVar;
        synchronized (d.class) {
            if (bWq == null) {
                bWq = new c();
            }
            cVar = bWq;
        }
        return cVar;
    }
}
