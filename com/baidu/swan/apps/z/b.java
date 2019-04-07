package com.baidu.swan.apps.z;
/* loaded from: classes2.dex */
public class b {
    private static volatile a aDl;

    public static synchronized a Fp() {
        a aVar;
        synchronized (b.class) {
            if (aDl == null) {
                aDl = new a();
            }
            aVar = aDl;
        }
        return aVar;
    }
}
