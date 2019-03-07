package com.baidu.swan.apps.scheme;
/* loaded from: classes2.dex */
public class b {
    private static volatile a aOS;

    public static synchronized a JF() {
        a aVar;
        synchronized (b.class) {
            if (aOS == null) {
                aOS = new a();
            }
            aVar = aOS;
        }
        return aVar;
    }
}
