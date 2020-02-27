package com.baidu.swan.apps.scheme;
/* loaded from: classes7.dex */
public class d {
    private static volatile c bQA;

    public static synchronized c adG() {
        c cVar;
        synchronized (d.class) {
            if (bQA == null) {
                bQA = new c();
            }
            cVar = bQA;
        }
        return cVar;
    }
}
