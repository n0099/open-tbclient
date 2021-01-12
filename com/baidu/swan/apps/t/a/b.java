package com.baidu.swan.apps.t.a;
/* loaded from: classes6.dex */
public class b {
    private static volatile a ddg;

    public static synchronized a axS() {
        a aVar;
        synchronized (b.class) {
            if (ddg == null) {
                ddg = new a();
            }
            aVar = ddg;
        }
        return aVar;
    }
}
