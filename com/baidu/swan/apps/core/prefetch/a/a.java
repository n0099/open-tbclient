package com.baidu.swan.apps.core.prefetch.a;

import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.b;
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int bmK = -1;

    public static int Nz() {
        if (com.baidu.swan.apps.ah.a.a.XW()) {
            bmK = 2;
            return bmK;
        }
        if (DEBUG && bmK == -1) {
            bmK = NA();
            Log.d("PrefetchABSwitcher", "getPrefetchABSwitch switch: " + bmK);
        }
        if (bmK == -1) {
            bmK = com.baidu.swan.apps.w.a.RJ().getSwitch("swan_prefetch_policy", 0);
        }
        return bmK;
    }

    public static int NA() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_prefetch_policy", -1);
    }
}
