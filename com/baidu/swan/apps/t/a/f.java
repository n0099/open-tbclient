package com.baidu.swan.apps.t.a;
/* loaded from: classes19.dex */
public class f {
    private static volatile e cWh;

    public static synchronized e axq() {
        e eVar;
        synchronized (f.class) {
            if (cWh == null) {
                cWh = new e();
            }
            eVar = cWh;
        }
        return eVar;
    }
}
