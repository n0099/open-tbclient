package com.baidu.swan.apps.core.prefetch.a;

import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.b;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int blU = -1;

    public static int Nd() {
        if (com.baidu.swan.apps.ah.a.a.Xz()) {
            blU = 2;
            return blU;
        }
        if (DEBUG && blU == -1) {
            blU = Ne();
            Log.d("PrefetchABSwitcher", "getPrefetchABSwitch switch: " + blU);
        }
        if (blU == -1) {
            blU = com.baidu.swan.apps.w.a.Rn().getSwitch("swan_prefetch_policy", 0);
        }
        return blU;
    }

    public static int Ne() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_prefetch_policy", -1);
    }
}
