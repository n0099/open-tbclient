package com.baidu.swan.apps.core.prefetch.a;

import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.b;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int bPt = -1;

    public static int XG() {
        if (com.baidu.swan.apps.ah.a.a.ait()) {
            bPt = 2;
            return bPt;
        }
        if (DEBUG && bPt == -1) {
            bPt = XH();
            Log.d("PrefetchABSwitcher", "getPrefetchABSwitch switch: " + bPt);
        }
        if (bPt == -1) {
            bPt = com.baidu.swan.apps.w.a.abQ().getSwitch("swan_prefetch_policy", 0);
        }
        return bPt;
    }

    public static int XH() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_prefetch_policy", -1);
    }
}
