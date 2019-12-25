package com.baidu.swan.apps.core.k;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
/* loaded from: classes9.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LruCache<String, Object> bnv;

    /* loaded from: classes9.dex */
    private static class a {
        static final c bnw = new c();
    }

    private c() {
        bnv = new LruCache<>(10);
    }

    public static c NJ() {
        return a.bnw;
    }

    public synchronized <CONFIG> CONFIG h(String str, CONFIG config) {
        Object obj;
        if (!TextUtils.isEmpty(str) && (obj = bnv.get(str)) != null) {
            if (DEBUG) {
                Log.d("SwanAppConfigCache", "getConfig hit key: " + str);
            }
            config = obj;
        }
        return config;
    }

    public synchronized <CONFIG> void i(String str, CONFIG config) {
        if (!TextUtils.isEmpty(str) && config != null) {
            if (DEBUG) {
                Log.d("SwanAppConfigCache", "putConfig key: " + str);
            }
            bnv.put(str, config);
        }
    }
}
