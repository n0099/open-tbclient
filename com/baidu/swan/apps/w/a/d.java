package com.baidu.swan.apps.w.a;
/* loaded from: classes4.dex */
public class d {
    private static volatile c bsZ;

    public static synchronized c Su() {
        c cVar;
        synchronized (d.class) {
            if (bsZ == null) {
                bsZ = new c();
            }
            cVar = bsZ;
        }
        return cVar;
    }
}
