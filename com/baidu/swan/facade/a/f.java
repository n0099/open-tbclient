package com.baidu.swan.facade.a;
/* loaded from: classes20.dex */
public class f {
    private static volatile e dEd;

    public static synchronized e aMu() {
        e eVar;
        synchronized (f.class) {
            if (dEd == null) {
                dEd = new e();
            }
            eVar = dEd;
        }
        return eVar;
    }
}
