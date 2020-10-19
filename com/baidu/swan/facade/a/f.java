package com.baidu.swan.facade.a;
/* loaded from: classes20.dex */
public class f {
    private static volatile e dvG;

    public static synchronized e aKA() {
        e eVar;
        synchronized (f.class) {
            if (dvG == null) {
                dvG = new e();
            }
            eVar = dvG;
        }
        return eVar;
    }
}
