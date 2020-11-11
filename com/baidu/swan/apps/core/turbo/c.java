package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
/* loaded from: classes10.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LruCache<String, Object> cQd;

    /* loaded from: classes10.dex */
    private static class a {
        static final c cQe = new c();
    }

    private c() {
        cQd = new LruCache<>(10);
    }

    public static c arE() {
        return a.cQe;
    }

    public synchronized <CONFIG> CONFIG o(String str, CONFIG config) {
        Object obj;
        if (!TextUtils.isEmpty(str) && (obj = cQd.get(str)) != null) {
            if (DEBUG) {
                Log.d("SwanAppConfigCache", "getConfig hit key: " + str);
            }
            config = obj;
        }
        return config;
    }

    public synchronized <CONFIG> void p(String str, CONFIG config) {
        if (!TextUtils.isEmpty(str) && config != null) {
            if (DEBUG) {
                Log.d("SwanAppConfigCache", "putConfig key: " + str);
            }
            cQd.put(str, config);
        }
    }
}
