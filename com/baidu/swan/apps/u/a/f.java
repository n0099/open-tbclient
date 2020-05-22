package com.baidu.swan.apps.u.a;
/* loaded from: classes7.dex */
public class f {
    private static volatile e cgW;

    public static synchronized e agh() {
        e eVar;
        synchronized (f.class) {
            if (cgW == null) {
                cgW = new e();
            }
            eVar = cgW;
        }
        return eVar;
    }
}
