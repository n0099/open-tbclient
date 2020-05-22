package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
/* loaded from: classes11.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static LruCache<String, Object> caD;

    /* loaded from: classes11.dex */
    private static class a {
        static final c caE = new c();
    }

    private c() {
        caD = new LruCache<>(10);
    }

    public static c abi() {
        return a.caE;
    }

    public synchronized <CONFIG> CONFIG o(String str, CONFIG config) {
        Object obj;
        if (!TextUtils.isEmpty(str) && (obj = caD.get(str)) != null) {
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
            caD.put(str, config);
        }
    }
}
