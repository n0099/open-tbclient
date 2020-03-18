package com.baidu.swan.apps.core.prefetch.a;

import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.b;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int brh = -1;

    public static int PS() {
        if (com.baidu.swan.apps.ah.a.a.aap()) {
            brh = 2;
            return brh;
        }
        if (DEBUG && brh == -1) {
            brh = PT();
            Log.d("PrefetchABSwitcher", "getPrefetchABSwitch switch: " + brh);
        }
        if (brh == -1) {
            brh = com.baidu.swan.apps.w.a.Uc().getSwitch("swan_prefetch_policy", 0);
        }
        return brh;
    }

    public static int PT() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_prefetch_policy", -1);
    }
}
