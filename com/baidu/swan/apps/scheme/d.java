package com.baidu.swan.apps.scheme;
/* loaded from: classes2.dex */
public class d {
    private static volatile c aSk;

    public static synchronized c MR() {
        c cVar;
        synchronized (d.class) {
            if (aSk == null) {
                aSk = new c();
            }
            cVar = aSk;
        }
        return cVar;
    }
}
