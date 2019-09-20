package com.baidu.swan.apps.z;
/* loaded from: classes2.dex */
public class b {
    private static volatile a aGe;

    public static synchronized a Ik() {
        a aVar;
        synchronized (b.class) {
            if (aGe == null) {
                aGe = new a();
            }
            aVar = aGe;
        }
        return aVar;
    }
}
