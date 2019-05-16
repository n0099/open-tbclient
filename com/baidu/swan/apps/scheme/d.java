package com.baidu.swan.apps.scheme;
/* loaded from: classes2.dex */
public class d {
    private static volatile c aRc;

    public static synchronized c LZ() {
        c cVar;
        synchronized (d.class) {
            if (aRc == null) {
                aRc = new c();
            }
            cVar = aRc;
        }
        return cVar;
    }
}
