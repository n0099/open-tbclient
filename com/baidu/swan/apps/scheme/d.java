package com.baidu.swan.apps.scheme;
/* loaded from: classes7.dex */
public class d {
    private static volatile c cpA;

    public static synchronized c alQ() {
        c cVar;
        synchronized (d.class) {
            if (cpA == null) {
                cpA = new c();
            }
            cVar = cpA;
        }
        return cVar;
    }
}
