package com.baidu.swan.apps.z;
/* loaded from: classes2.dex */
public class b {
    private static volatile a aEY;

    public static synchronized a Hu() {
        a aVar;
        synchronized (b.class) {
            if (aEY == null) {
                aEY = new a();
            }
            aVar = aEY;
        }
        return aVar;
    }
}
