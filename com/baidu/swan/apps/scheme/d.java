package com.baidu.swan.apps.scheme;
/* loaded from: classes7.dex */
public class d {
    private static volatile c cpG;

    public static synchronized c alP() {
        c cVar;
        synchronized (d.class) {
            if (cpG == null) {
                cpG = new c();
            }
            cVar = cpG;
        }
        return cVar;
    }
}
