package com.baidu.swan.apps.scheme;
/* loaded from: classes4.dex */
public class d {
    private static volatile c bLL;

    public static synchronized c aaV() {
        c cVar;
        synchronized (d.class) {
            if (bLL == null) {
                bLL = new c();
            }
            cVar = bLL;
        }
        return cVar;
    }
}
