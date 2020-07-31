package com.baidu.swan.apps.core.prefetch.a;

import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.b;
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int cfv = -1;

    public static int acD() {
        if (com.baidu.swan.apps.ae.a.a.aoP()) {
            cfv = 2;
            return cfv;
        }
        if (DEBUG && cfv == -1) {
            cfv = acE();
            Log.d("PrefetchABSwitcher", "getPrefetchABSwitch switch: " + cfv);
        }
        if (cfv == -1) {
            cfv = com.baidu.swan.apps.t.a.ahm().getSwitch("swan_prefetch_policy", 0);
        }
        return cfv;
    }

    public static int acE() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_prefetch_policy", -1);
    }
}
