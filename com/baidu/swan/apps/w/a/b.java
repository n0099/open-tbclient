package com.baidu.swan.apps.w.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a bWn;

    public static synchronized a acU() {
        a aVar;
        synchronized (b.class) {
            if (bWn == null) {
                bWn = new a();
            }
            aVar = bWn;
        }
        return aVar;
    }
}
