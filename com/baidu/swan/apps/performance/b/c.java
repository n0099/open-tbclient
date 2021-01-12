package com.baidu.swan.apps.performance.b;

import android.util.Log;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean dps = mI("swan_get_swan_id_cache");
    private static boolean dpt = mI("swan_update_async");
    private static boolean dpu = com.baidu.swan.apps.t.a.awB().getSwitch("swan_update_async_merge_node", false);
    private static boolean dpv = mI("swan_pre_app_launch");
    private static boolean dpw = mI("swan_prevent_series_launch");
    private static int dpx = com.baidu.swan.apps.t.a.awB().getSwitch("swan_prevent_series_launch_interval", 200);
    private static boolean dpy = mI("swan_pre_class_loader");
    private static boolean dpz = com.baidu.swan.apps.t.a.awB().agM();
    private static boolean dpA = mI("swan_release_runtime_wait_master_finish");

    private static boolean mI(String str) {
        int i = com.baidu.swan.apps.t.a.awB().getSwitch(str, 0);
        if (DEBUG) {
            Log.d("SwanApiCostOpt", str + " value : " + i);
        }
        return i == 1;
    }

    public static boolean aDX() {
        return dps;
    }

    public static boolean aDY() {
        return dpt;
    }

    public static boolean aDZ() {
        return dpu;
    }

    public static boolean aEa() {
        return dpv;
    }

    public static boolean aEb() {
        return dpw;
    }

    public static int aEc() {
        return dpx;
    }

    public static boolean aEd() {
        return dpy;
    }

    public static boolean agM() {
        return dpz;
    }

    public static boolean aEe() {
        return dpA;
    }
}
