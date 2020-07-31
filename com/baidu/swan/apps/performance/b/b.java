package com.baidu.swan.apps.performance.b;

import android.util.Log;
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean czj = nr("swan_api_cost_opt_v1");
    private static boolean czk = nr("swan_api_cost_opt_v2");
    private static boolean czl = nr("swan_api_cost_opt_v3");
    private static boolean czm = nr("swan_get_swan_id_cache");

    private static boolean nr(String str) {
        int i = com.baidu.swan.apps.t.a.ahm().getSwitch(str, 0);
        if (DEBUG) {
            Log.d("SwanApiCostOpt", str + " value : " + i);
        }
        return i == 1;
    }

    public static boolean aom() {
        return czj;
    }

    public static boolean aon() {
        return czk;
    }

    public static boolean aoo() {
        return czl;
    }

    public static boolean aop() {
        return czm;
    }
}
