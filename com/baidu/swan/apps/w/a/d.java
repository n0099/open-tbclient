package com.baidu.swan.apps.w.a;
/* loaded from: classes7.dex */
public class d {
    private static volatile c bxZ;

    public static synchronized c Vg() {
        c cVar;
        synchronized (d.class) {
            if (bxZ == null) {
                bxZ = new c();
            }
            cVar = bxZ;
        }
        return cVar;
    }
}
