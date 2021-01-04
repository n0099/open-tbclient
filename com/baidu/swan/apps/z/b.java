package com.baidu.swan.apps.z;
/* loaded from: classes7.dex */
public class b {
    private static volatile a dsy;

    public static synchronized a aGY() {
        a aVar;
        synchronized (b.class) {
            if (dsy == null) {
                dsy = new a();
            }
            aVar = dsy;
        }
        return aVar;
    }
}
