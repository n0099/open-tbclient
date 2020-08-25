package com.baidu.swan.apps.scheme;
/* loaded from: classes14.dex */
public class d {
    private static volatile c cRY;

    public static synchronized c aAO() {
        c cVar;
        synchronized (d.class) {
            if (cRY == null) {
                cRY = new c();
            }
            cVar = cRY;
        }
        return cVar;
    }
}
