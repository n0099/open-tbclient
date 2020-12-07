package com.baidu.swan.apps.t.a;
/* loaded from: classes20.dex */
public class f {
    private static volatile e dde;

    public static synchronized e aAz() {
        e eVar;
        synchronized (f.class) {
            if (dde == null) {
                dde = new e();
            }
            eVar = dde;
        }
        return eVar;
    }
}
