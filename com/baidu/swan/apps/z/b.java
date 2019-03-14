package com.baidu.swan.apps.z;
/* loaded from: classes2.dex */
public class b {
    private static volatile a aDi;

    public static synchronized a Fr() {
        a aVar;
        synchronized (b.class) {
            if (aDi == null) {
                aDi = new a();
            }
            aVar = aDi;
        }
        return aVar;
    }
}
