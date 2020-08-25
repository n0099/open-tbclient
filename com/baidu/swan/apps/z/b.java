package com.baidu.swan.apps.z;
/* loaded from: classes14.dex */
public class b {
    private static volatile a cFF;

    public static synchronized a avp() {
        a aVar;
        synchronized (b.class) {
            if (cFF == null) {
                cFF = new a();
            }
            aVar = cFF;
        }
        return aVar;
    }
}
