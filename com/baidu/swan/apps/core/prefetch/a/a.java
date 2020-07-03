package com.baidu.swan.apps.core.prefetch.a;

import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.b;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int cdO = -1;

    public static int abB() {
        if (com.baidu.swan.apps.af.a.a.ang()) {
            cdO = 2;
            return cdO;
        }
        if (DEBUG && cdO == -1) {
            cdO = abC();
            Log.d("PrefetchABSwitcher", "getPrefetchABSwitch switch: " + cdO);
        }
        if (cdO == -1) {
            cdO = com.baidu.swan.apps.u.a.aga().getSwitch("swan_prefetch_policy", 0);
        }
        return cdO;
    }

    public static int abC() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_prefetch_policy", -1);
    }
}
