package com.baidu.swan.apps.z;
/* loaded from: classes2.dex */
public class b {
    private static volatile a aFG;

    public static synchronized a Ig() {
        a aVar;
        synchronized (b.class) {
            if (aFG == null) {
                aFG = new a();
            }
            aVar = aFG;
        }
        return aVar;
    }
}
