package com.baidu.swan.apps.z;
/* loaded from: classes2.dex */
public class b {
    private static volatile a aZt;

    public static synchronized a Ne() {
        a aVar;
        synchronized (b.class) {
            if (aZt == null) {
                aZt = new a();
            }
            aVar = aZt;
        }
        return aVar;
    }
}
