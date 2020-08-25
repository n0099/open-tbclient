package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> cYq = new HashMap();

    public static b aDf() {
        return rZ("searchbox_webapps_sp");
    }

    public static b rZ(String str) {
        b bVar = cYq.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = cYq.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    cYq.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
