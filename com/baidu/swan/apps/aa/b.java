package com.baidu.swan.apps.aa;
/* loaded from: classes14.dex */
public class b {
    private static volatile a cxL;

    public static synchronized a anu() {
        a aVar;
        synchronized (b.class) {
            if (cxL == null) {
                cxL = new a();
            }
            aVar = cxL;
        }
        return aVar;
    }
}
