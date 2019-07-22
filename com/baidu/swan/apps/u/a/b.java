package com.baidu.swan.apps.u.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a ayR;

    public static synchronized a Fc() {
        a aVar;
        synchronized (b.class) {
            if (ayR == null) {
                ayR = new a();
            }
            aVar = ayR;
        }
        return aVar;
    }
}
