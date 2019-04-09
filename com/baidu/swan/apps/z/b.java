package com.baidu.swan.apps.z;
/* loaded from: classes2.dex */
public class b {
    private static volatile a aDm;

    public static synchronized a Fp() {
        a aVar;
        synchronized (b.class) {
            if (aDm == null) {
                aDm = new a();
            }
            aVar = aDm;
        }
        return aVar;
    }
}
