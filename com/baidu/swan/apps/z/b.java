package com.baidu.swan.apps.z;
/* loaded from: classes2.dex */
public class b {
    private static volatile a aZb;

    public static synchronized a Nf() {
        a aVar;
        synchronized (b.class) {
            if (aZb == null) {
                aZb = new a();
            }
            aVar = aZb;
        }
        return aVar;
    }
}
