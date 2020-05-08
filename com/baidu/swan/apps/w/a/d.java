package com.baidu.swan.apps.w.a;
/* loaded from: classes7.dex */
public class d {
    private static volatile c bWw;

    public static synchronized c acX() {
        c cVar;
        synchronized (d.class) {
            if (bWw == null) {
                bWw = new c();
            }
            cVar = bWw;
        }
        return cVar;
    }
}
