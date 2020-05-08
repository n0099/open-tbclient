package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> cvg = new HashMap();

    public static b any() {
        return nz("searchbox_webapps_sp");
    }

    public static b nz(String str) {
        b bVar = cvg.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = cvg.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    cvg.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
