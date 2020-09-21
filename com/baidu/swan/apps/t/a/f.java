package com.baidu.swan.apps.t.a;
/* loaded from: classes19.dex */
public class f {
    private static volatile e cxx;

    public static synchronized e aqS() {
        e eVar;
        synchronized (f.class) {
            if (cxx == null) {
                cxx = new e();
            }
            eVar = cxx;
        }
        return eVar;
    }
}
