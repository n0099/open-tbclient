package com.baidu.swan.apps.t.a;
/* loaded from: classes7.dex */
public class f {
    private static volatile e dfw;

    public static synchronized e ayv() {
        e eVar;
        synchronized (f.class) {
            if (dfw == null) {
                dfw = new e();
            }
            eVar = dfw;
        }
        return eVar;
    }
}
