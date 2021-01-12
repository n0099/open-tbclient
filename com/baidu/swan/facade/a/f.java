package com.baidu.swan.facade.a;
/* loaded from: classes6.dex */
public class f {
    private static volatile e dTv;

    public static synchronized e aPT() {
        e eVar;
        synchronized (f.class) {
            if (dTv == null) {
                dTv = new e();
            }
            eVar = dTv;
        }
        return eVar;
    }
}
