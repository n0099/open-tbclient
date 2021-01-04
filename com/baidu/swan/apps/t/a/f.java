package com.baidu.swan.apps.t.a;
/* loaded from: classes7.dex */
public class f {
    private static volatile e dhX;

    public static synchronized e aBQ() {
        e eVar;
        synchronized (f.class) {
            if (dhX == null) {
                dhX = new e();
            }
            eVar = dhX;
        }
        return eVar;
    }
}
