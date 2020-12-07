package com.baidu.swan.apps.performance.b;

import android.util.Log;
/* loaded from: classes25.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean dpi = oa("swan_get_swan_id_cache");
    private static boolean dpj = oa("swan_update_async");
    private static boolean dpk = com.baidu.swan.apps.t.a.azd().getSwitch("swan_update_async_merge_node", false);
    private static boolean dpl = oa("swan_pre_app_launch");
    private static boolean dpm = oa("swan_prevent_series_launch");
    private static int dpn = com.baidu.swan.apps.t.a.azd().getSwitch("swan_prevent_series_launch_interval", 200);
    private static boolean dpo = oa("swan_pre_class_loader");
    private static boolean dpp = com.baidu.swan.apps.t.a.azd().ajx();
    private static boolean dpq = oa("swan_release_runtime_wait_master_finish");

    private static boolean oa(String str) {
        int i = com.baidu.swan.apps.t.a.azd().getSwitch(str, 0);
        if (DEBUG) {
            Log.d("SwanApiCostOpt", str + " value : " + i);
        }
        return i == 1;
    }

    public static boolean aGx() {
        return dpi;
    }

    public static boolean aGy() {
        return dpj;
    }

    public static boolean aGz() {
        return dpk;
    }

    public static boolean aGA() {
        return dpl;
    }

    public static boolean aGB() {
        return dpm;
    }

    public static int aGC() {
        return dpn;
    }

    public static boolean aGD() {
        return dpo;
    }

    public static boolean ajx() {
        return dpp;
    }

    public static boolean aGE() {
        return dpq;
    }
}
