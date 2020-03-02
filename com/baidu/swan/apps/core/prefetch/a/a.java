package com.baidu.swan.apps.core.prefetch.a;

import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.b;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int bqU = -1;

    public static int PP() {
        if (com.baidu.swan.apps.ah.a.a.aam()) {
            bqU = 2;
            return bqU;
        }
        if (DEBUG && bqU == -1) {
            bqU = PQ();
            Log.d("PrefetchABSwitcher", "getPrefetchABSwitch switch: " + bqU);
        }
        if (bqU == -1) {
            bqU = com.baidu.swan.apps.w.a.TZ().getSwitch("swan_prefetch_policy", 0);
        }
        return bqU;
    }

    public static int PQ() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_prefetch_policy", -1);
    }
}
