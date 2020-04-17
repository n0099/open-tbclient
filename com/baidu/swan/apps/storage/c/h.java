package com.baidu.swan.apps.storage.c;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public final class h {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    static final Map<String, b> cva = new HashMap();

    public static b anz() {
        return nz("searchbox_webapps_sp");
    }

    public static b nz(String str) {
        b bVar = cva.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = cva.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    cva.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
