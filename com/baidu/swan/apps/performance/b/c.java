package com.baidu.swan.apps.performance.b;

import android.util.Log;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean dtf = nh("swan_get_swan_id_cache");
    private static boolean dtg = nh("swan_update_async");
    private static boolean dth = com.baidu.swan.apps.t.a.axc().getSwitch("swan_update_async_merge_node", false);
    private static boolean dti = nh("swan_pre_app_launch");
    private static boolean dtj = nh("swan_prevent_series_launch");
    private static int dtk = com.baidu.swan.apps.t.a.axc().getSwitch("swan_prevent_series_launch_interval", 200);
    private static boolean dtl = nh("swan_pre_class_loader");
    private static boolean dtm = com.baidu.swan.apps.t.a.axc().ahn();
    private static boolean dtn = nh("swan_release_runtime_wait_master_finish");

    private static boolean nh(String str) {
        int i = com.baidu.swan.apps.t.a.axc().getSwitch(str, 0);
        if (DEBUG) {
            Log.d("SwanApiCostOpt", str + " value : " + i);
        }
        return i == 1;
    }

    public static boolean aEv() {
        return dtf;
    }

    public static boolean aEw() {
        return dtg;
    }

    public static boolean aEx() {
        return dth;
    }

    public static boolean aEy() {
        return dti;
    }

    public static boolean aEz() {
        return dtj;
    }

    public static int aEA() {
        return dtk;
    }

    public static boolean aEB() {
        return dtl;
    }

    public static boolean ahn() {
        return dtm;
    }

    public static boolean aEC() {
        return dtn;
    }
}
