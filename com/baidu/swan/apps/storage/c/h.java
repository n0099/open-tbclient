package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> dOU = new HashMap();

    public static b aPI() {
        return um("searchbox_webapps_sp");
    }

    public static b um(String str) {
        b bVar = dOU.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = dOU.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    dOU.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
