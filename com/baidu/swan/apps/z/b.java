package com.baidu.swan.apps.z;
/* loaded from: classes2.dex */
public class b {
    private static volatile a aDh;

    public static synchronized a Fr() {
        a aVar;
        synchronized (b.class) {
            if (aDh == null) {
                aDh = new a();
            }
            aVar = aDh;
        }
        return aVar;
    }
}
