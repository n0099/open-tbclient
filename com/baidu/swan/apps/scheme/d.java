package com.baidu.swan.apps.scheme;
/* loaded from: classes7.dex */
public class d {
    private static volatile c cBw;

    public static synchronized c apN() {
        c cVar;
        synchronized (d.class) {
            if (cBw == null) {
                cBw = new c();
            }
            cVar = cBw;
        }
        return cVar;
    }
}
