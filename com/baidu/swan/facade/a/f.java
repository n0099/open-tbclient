package com.baidu.swan.facade.a;
/* loaded from: classes20.dex */
public class f {
    private static volatile e dPl;

    public static synchronized e aRr() {
        e eVar;
        synchronized (f.class) {
            if (dPl == null) {
                dPl = new e();
            }
            eVar = dPl;
        }
        return eVar;
    }
}
