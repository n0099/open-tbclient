package com.baidu.swan.apps.u.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a aSm;

    public static synchronized a Kb() {
        a aVar;
        synchronized (b.class) {
            if (aSm == null) {
                aSm = new a();
            }
            aVar = aSm;
        }
        return aVar;
    }
}
