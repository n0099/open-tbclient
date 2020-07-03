package com.baidu.swan.apps.performance.b;

import android.util.Log;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean cwT;

    static {
        int i = com.baidu.swan.apps.u.a.aga().getSwitch("swan_api_cost_opt_v1", 0);
        if (DEBUG) {
            Log.d("SwanApiCostOpt", "swan_api_cost_opt_v1 value : " + i);
        }
        cwT = i == 1;
    }

    public static boolean amR() {
        return cwT;
    }
}
