package com.baidu.swan.apps.scheme;
/* loaded from: classes2.dex */
public class b {
    private static volatile a bkV;

    public static synchronized a RK() {
        a aVar;
        synchronized (b.class) {
            if (bkV == null) {
                bkV = new a();
            }
            aVar = bkV;
        }
        return aVar;
    }
}
