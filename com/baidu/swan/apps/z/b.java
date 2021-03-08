package com.baidu.swan.apps.z;
/* loaded from: classes6.dex */
public class b {
    private static volatile a drw;

    public static synchronized a aDE() {
        a aVar;
        synchronized (b.class) {
            if (drw == null) {
                drw = new a();
            }
            aVar = drw;
        }
        return aVar;
    }
}
