package com.baidu.swan.apps.u.a;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
/* loaded from: classes25.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final LruCache<String, Object> ddw;

    /* loaded from: classes25.dex */
    private static class a {
        static final b ddx = new b();
    }

    private b() {
        this.ddw = new LruCache<>(10);
    }

    public static b aAL() {
        return a.ddx;
    }

    public synchronized <RESULT> RESULT pB(String str) {
        RESULT result = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                Object obj = this.ddw.get(str);
                if (obj == null) {
                    if (DEBUG) {
                        Log.d("SwanAppLaunchCache", "doesn't hit the cache result, key = " + str);
                    }
                } else {
                    try {
                        if (DEBUG) {
                            Log.d("SwanAppLaunchCache", "hit the cache result, key = " + str);
                        }
                        result = obj;
                    } catch (Exception e) {
                        if (DEBUG) {
                            Log.e("SwanAppLaunchCache", Log.getStackTraceString(e));
                        }
                    }
                }
            }
        }
        return result;
    }

    public synchronized <RESULT> void o(String str, RESULT result) {
        if (!TextUtils.isEmpty(str) && result != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchCache", "putConfig key: " + str);
            }
            this.ddw.put(str, result);
        }
    }

    public synchronized void pC(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("SwanAppLaunchCache", "removeConfig key: " + str);
            }
            this.ddw.remove(str);
        }
    }

    public synchronized void clear() {
        if (this.ddw != null) {
            this.ddw.evictAll();
        }
    }
}
