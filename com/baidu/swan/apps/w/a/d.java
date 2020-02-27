package com.baidu.swan.apps.w.a;
/* loaded from: classes7.dex */
public class d {
    private static volatile c bxX;

    public static synchronized c Ve() {
        c cVar;
        synchronized (d.class) {
            if (bxX == null) {
                bxX = new c();
            }
            cVar = bxX;
        }
        return cVar;
    }
}
