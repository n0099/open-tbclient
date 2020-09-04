package com.baidu.swan.apps.z;
/* loaded from: classes14.dex */
public class b {
    private static volatile a cFJ;

    public static synchronized a avp() {
        a aVar;
        synchronized (b.class) {
            if (cFJ == null) {
                cFJ = new a();
            }
            aVar = cFJ;
        }
        return aVar;
    }
}
