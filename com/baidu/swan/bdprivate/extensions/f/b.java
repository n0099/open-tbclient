package com.baidu.swan.bdprivate.extensions.f;
/* loaded from: classes7.dex */
public class b {
    private static volatile a dUW;

    public static synchronized a aPX() {
        a aVar;
        synchronized (b.class) {
            if (dUW == null) {
                dUW = new a();
            }
            aVar = dUW;
        }
        return aVar;
    }
}
