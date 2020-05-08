package com.baidu.swan.apps.w.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a bWt;

    public static synchronized a acT() {
        a aVar;
        synchronized (b.class) {
            if (bWt == null) {
                bWt = new a();
            }
            aVar = bWt;
        }
        return aVar;
    }
}
