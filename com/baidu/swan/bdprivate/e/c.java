package com.baidu.swan.bdprivate.e;
/* loaded from: classes7.dex */
public class c {
    private static volatile b cTp;

    public static synchronized b avZ() {
        b bVar;
        synchronized (c.class) {
            if (cTp == null) {
                cTp = new b();
            }
            bVar = cTp;
        }
        return bVar;
    }
}
