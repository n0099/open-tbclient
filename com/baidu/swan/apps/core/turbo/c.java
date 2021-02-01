package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
/* loaded from: classes9.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LruCache<String, Object> cXI;

    /* loaded from: classes9.dex */
    private static class a {
        static final c cXJ = new c();
    }

    private c() {
        cXI = new LruCache<>(10);
    }

    public static c asa() {
        return a.cXJ;
    }

    public synchronized <CONFIG> CONFIG l(String str, CONFIG config) {
        Object obj;
        if (!TextUtils.isEmpty(str) && (obj = cXI.get(str)) != null) {
            if (DEBUG) {
                Log.d("SwanAppConfigCache", "getConfig hit key: " + str);
            }
            config = obj;
        }
        return config;
    }

    public synchronized <CONFIG> void m(String str, CONFIG config) {
        if (!TextUtils.isEmpty(str) && config != null) {
            if (DEBUG) {
                Log.d("SwanAppConfigCache", "putConfig key: " + str);
            }
            cXI.put(str, config);
        }
    }
}
