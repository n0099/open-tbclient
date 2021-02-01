package com.baidu.swan.bdprivate.d;
/* loaded from: classes7.dex */
public class c {
    private static volatile b dVo;

    public static synchronized b aQb() {
        b bVar;
        synchronized (c.class) {
            if (dVo == null) {
                dVo = new b();
            }
            bVar = dVo;
        }
        return bVar;
    }
}
