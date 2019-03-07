package com.baidu.swan.apps.u.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a axr;

    public static synchronized a Dq() {
        a aVar;
        synchronized (b.class) {
            if (axr == null) {
                axr = new a();
            }
            aVar = axr;
        }
        return aVar;
    }
}
