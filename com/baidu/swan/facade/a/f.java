package com.baidu.swan.facade.a;
/* loaded from: classes14.dex */
public class f {
    private static volatile e dhx;

    public static synchronized e aHh() {
        e eVar;
        synchronized (f.class) {
            if (dhx == null) {
                dhx = new e();
            }
            eVar = dhx;
        }
        return eVar;
    }
}
