package com.baidu.swan.apps.core.prefetch.a;

import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.b;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int bqT = -1;

    public static int PN() {
        if (com.baidu.swan.apps.ah.a.a.aak()) {
            bqT = 2;
            return bqT;
        }
        if (DEBUG && bqT == -1) {
            bqT = PO();
            Log.d("PrefetchABSwitcher", "getPrefetchABSwitch switch: " + bqT);
        }
        if (bqT == -1) {
            bqT = com.baidu.swan.apps.w.a.TX().getSwitch("swan_prefetch_policy", 0);
        }
        return bqT;
    }

    public static int PO() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_prefetch_policy", -1);
    }
}
