package com.baidu.swan.apps.u.a;
/* loaded from: classes7.dex */
public class d {
    private static volatile c cgV;

    public static synchronized c age() {
        c cVar;
        synchronized (d.class) {
            if (cgV == null) {
                cgV = new c();
            }
            cVar = cgV;
        }
        return cVar;
    }
}
