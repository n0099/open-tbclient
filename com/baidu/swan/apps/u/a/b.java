package com.baidu.swan.apps.u.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a cgT;

    public static synchronized a agd() {
        a aVar;
        synchronized (b.class) {
            if (cgT == null) {
                cgT = new a();
            }
            aVar = cgT;
        }
        return aVar;
    }
}
