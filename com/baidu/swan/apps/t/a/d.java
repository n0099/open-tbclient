package com.baidu.swan.apps.t.a;
/* loaded from: classes14.dex */
public class d {
    private static volatile c cnN;

    public static synchronized c aiz() {
        c cVar;
        synchronized (d.class) {
            if (cnN == null) {
                cnN = new c();
            }
            cVar = cnN;
        }
        return cVar;
    }
}
