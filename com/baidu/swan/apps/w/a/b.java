package com.baidu.swan.apps.w.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a bxW;

    public static synchronized a Vc() {
        a aVar;
        synchronized (b.class) {
            if (bxW == null) {
                bxW = new a();
            }
            aVar = bxW;
        }
        return aVar;
    }
}
