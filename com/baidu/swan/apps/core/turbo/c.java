package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
/* loaded from: classes25.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LruCache<String, Object> cVm;

    /* loaded from: classes25.dex */
    private static class a {
        static final c cVn = new c();
    }

    private c() {
        cVm = new LruCache<>(10);
    }

    public static c aue() {
        return a.cVn;
    }

    public synchronized <CONFIG> CONFIG n(String str, CONFIG config) {
        Object obj;
        if (!TextUtils.isEmpty(str) && (obj = cVm.get(str)) != null) {
            if (DEBUG) {
                Log.d("SwanAppConfigCache", "getConfig hit key: " + str);
            }
            config = obj;
        }
        return config;
    }

    public synchronized <CONFIG> void o(String str, CONFIG config) {
        if (!TextUtils.isEmpty(str) && config != null) {
            if (DEBUG) {
                Log.d("SwanAppConfigCache", "putConfig key: " + str);
            }
            cVm.put(str, config);
        }
    }
}
