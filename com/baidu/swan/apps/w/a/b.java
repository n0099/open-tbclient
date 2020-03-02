package com.baidu.swan.apps.w.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a bxV;

    public static synchronized a Vc() {
        a aVar;
        synchronized (b.class) {
            if (bxV == null) {
                bxV = new a();
            }
            aVar = bxV;
        }
        return aVar;
    }
}
