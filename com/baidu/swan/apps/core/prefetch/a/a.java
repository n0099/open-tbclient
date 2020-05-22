package com.baidu.swan.apps.core.prefetch.a;

import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.b;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int bYY = -1;

    public static int aav() {
        if (com.baidu.swan.apps.af.a.a.ama()) {
            bYY = 2;
            return bYY;
        }
        if (DEBUG && bYY == -1) {
            bYY = aaw();
            Log.d("PrefetchABSwitcher", "getPrefetchABSwitch switch: " + bYY);
        }
        if (bYY == -1) {
            bYY = com.baidu.swan.apps.u.a.aeU().getSwitch("swan_prefetch_policy", 0);
        }
        return bYY;
    }

    public static int aaw() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_prefetch_policy", -1);
    }
}
