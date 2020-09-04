package com.baidu.swan.apps.scheme;
/* loaded from: classes14.dex */
public class d {
    private static volatile c cSc;

    public static synchronized c aAO() {
        c cVar;
        synchronized (d.class) {
            if (cSc == null) {
                cSc = new c();
            }
            cVar = cSc;
        }
        return cVar;
    }
}
