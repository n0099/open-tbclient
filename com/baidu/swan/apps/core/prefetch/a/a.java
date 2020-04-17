package com.baidu.swan.apps.core.prefetch.a;

import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.b;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int bPo = -1;

    public static int XH() {
        if (com.baidu.swan.apps.ah.a.a.aiu()) {
            bPo = 2;
            return bPo;
        }
        if (DEBUG && bPo == -1) {
            bPo = XI();
            Log.d("PrefetchABSwitcher", "getPrefetchABSwitch switch: " + bPo);
        }
        if (bPo == -1) {
            bPo = com.baidu.swan.apps.w.a.abR().getSwitch("swan_prefetch_policy", 0);
        }
        return bPo;
    }

    public static int XI() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_prefetch_policy", -1);
    }
}
