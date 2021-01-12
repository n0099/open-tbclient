package com.baidu.swan.apps.z;
/* loaded from: classes6.dex */
public class b {
    private static volatile a dnH;

    public static synchronized a aDf() {
        a aVar;
        synchronized (b.class) {
            if (dnH == null) {
                dnH = new a();
            }
            aVar = dnH;
        }
        return aVar;
    }
}
