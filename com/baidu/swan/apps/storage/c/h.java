package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> dKi = new HashMap();

    public static b aLO() {
        return tb("searchbox_webapps_sp");
    }

    public static b tb(String str) {
        b bVar = dKi.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = dKi.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    dKi.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
