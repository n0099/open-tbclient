package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> bVX = new HashMap();

    public static b afr() {
        return mn("searchbox_webapps_sp");
    }

    public static b mn(String str) {
        b bVar = bVX.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = bVX.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    bVX.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
