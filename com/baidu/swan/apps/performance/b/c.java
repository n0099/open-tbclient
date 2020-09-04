package com.baidu.swan.apps.performance.b;

import android.util.Log;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean cHr = lM("swan_get_swan_id_cache");
    private static boolean cHs = lM("swan_update_async");
    private static boolean cHt = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_update_async_merge_node", false);
    private static boolean cHu = lM("swan_pre_app_launch");
    private static boolean cHv = lM("swan_prevent_series_launch");
    private static int cHw = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_prevent_series_launch_interval", 200);
    private static boolean cHx = lM("swan_pre_class_loader");
    private static boolean cHy = com.baidu.swan.apps.t.a.aoM().Zi();
    private static boolean cHz = lM("swan_release_runtime_wait_master_finish");

    private static boolean lM(String str) {
        int i = com.baidu.swan.apps.t.a.aoM().getSwitch(str, 0);
        if (DEBUG) {
            Log.d("SwanApiCostOpt", str + " value : " + i);
        }
        return i == 1;
    }

    public static boolean awj() {
        return cHr;
    }

    public static boolean awk() {
        return cHs;
    }

    public static boolean awl() {
        return cHt;
    }

    public static boolean awm() {
        return cHu;
    }

    public static boolean awn() {
        return cHv;
    }

    public static int awo() {
        return cHw;
    }

    public static boolean awp() {
        return cHx;
    }

    public static boolean Zi() {
        return cHy;
    }

    public static boolean awq() {
        return cHz;
    }
}
