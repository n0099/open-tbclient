package com.baidu.swan.apps.z;
/* loaded from: classes19.dex */
public class b {
    private static volatile a dgy;

    public static synchronized a aCv() {
        a aVar;
        synchronized (b.class) {
            if (dgy == null) {
                dgy = new a();
            }
            aVar = dgy;
        }
        return aVar;
    }
}
