package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes25.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> dGq = new HashMap();

    public static b aNr() {
        return up("searchbox_webapps_sp");
    }

    public static b up(String str) {
        b bVar = dGq.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = dGq.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    dGq.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
