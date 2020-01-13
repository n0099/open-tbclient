package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> bRS = new HashMap();

    public static b adb() {
        return lY("searchbox_webapps_sp");
    }

    public static b lY(String str) {
        b bVar = bRS.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = bRS.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    bRS.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
