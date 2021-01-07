package com.baidu.swan.apps.scheme;
/* loaded from: classes7.dex */
public class b {
    private static volatile a dID;

    public static synchronized a aNq() {
        a aVar;
        synchronized (b.class) {
            if (dID == null) {
                dID = new a();
            }
            aVar = dID;
        }
        return aVar;
    }
}
