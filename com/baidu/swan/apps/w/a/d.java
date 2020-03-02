package com.baidu.swan.apps.w.a;
/* loaded from: classes7.dex */
public class d {
    private static volatile c bxY;

    public static synchronized c Vg() {
        c cVar;
        synchronized (d.class) {
            if (bxY == null) {
                bxY = new c();
            }
            cVar = bxY;
        }
        return cVar;
    }
}
