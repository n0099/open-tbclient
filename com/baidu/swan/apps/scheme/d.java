package com.baidu.swan.apps.scheme;
/* loaded from: classes2.dex */
public class d {
    private static volatile c bkW;

    public static synchronized c RL() {
        c cVar;
        synchronized (d.class) {
            if (bkW == null) {
                bkW = new c();
            }
            cVar = bkW;
        }
        return cVar;
    }
}
