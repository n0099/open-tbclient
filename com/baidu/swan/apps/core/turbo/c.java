package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
/* loaded from: classes7.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LruCache<String, Object> chc;

    /* loaded from: classes7.dex */
    private static class a {
        static final c chd = new c();
    }

    private c() {
        chc = new LruCache<>(10);
    }

    public static c adt() {
        return a.chd;
    }

    public synchronized <CONFIG> CONFIG o(String str, CONFIG config) {
        Object obj;
        if (!TextUtils.isEmpty(str) && (obj = chc.get(str)) != null) {
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
            chc.put(str, config);
        }
    }
}
