package com.baidu.swan.apps.scheme;
/* loaded from: classes14.dex */
public class d {
    private static volatile c cIY;

    public static synchronized c asC() {
        c cVar;
        synchronized (d.class) {
            if (cIY == null) {
                cIY = new c();
            }
            cVar = cIY;
        }
        return cVar;
    }
}
