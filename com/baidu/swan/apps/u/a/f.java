package com.baidu.swan.apps.u.a;
/* loaded from: classes7.dex */
public class f {
    private static volatile e clK;

    public static synchronized e ahn() {
        e eVar;
        synchronized (f.class) {
            if (clK == null) {
                clK = new e();
            }
            eVar = clK;
        }
        return eVar;
    }
}
