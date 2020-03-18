package com.baidu.swan.apps.w.a;
/* loaded from: classes7.dex */
public class d {
    private static volatile c byk;

    public static synchronized c Vj() {
        c cVar;
        synchronized (d.class) {
            if (byk == null) {
                byk = new c();
            }
            cVar = byk;
        }
        return cVar;
    }
}
