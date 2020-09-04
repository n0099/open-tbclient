package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> cYu = new HashMap();

    public static b aDf() {
        return sa("searchbox_webapps_sp");
    }

    public static b sa(String str) {
        b bVar = cYu.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = cYu.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    cYu.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
