package com.baidu.swan.facade.a;
/* loaded from: classes7.dex */
public class f {
    private static volatile e cPb;

    public static synchronized e avi() {
        e eVar;
        synchronized (f.class) {
            if (cPb == null) {
                cPb = new e();
            }
            eVar = cPb;
        }
        return eVar;
    }
}
