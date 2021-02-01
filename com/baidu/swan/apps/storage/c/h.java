package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> dMm = new HashMap();

    public static b aMh() {
        return tu("searchbox_webapps_sp");
    }

    public static b tu(String str) {
        b bVar = dMm.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = dMm.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    dMm.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
