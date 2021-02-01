package com.baidu.swan.apps.performance.b;

import android.util.Log;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean drD = na("swan_get_swan_id_cache");
    private static boolean drE = na("swan_update_async");
    private static boolean drF = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_update_async_merge_node", false);
    private static boolean drG = na("swan_pre_app_launch");
    private static boolean drH = na("swan_prevent_series_launch");
    private static int drI = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_prevent_series_launch_interval", 200);
    private static boolean drJ = na("swan_pre_class_loader");
    private static boolean drK = com.baidu.swan.apps.t.a.awZ().ahk();
    private static boolean drL = na("swan_release_runtime_wait_master_finish");

    private static boolean na(String str) {
        int i = com.baidu.swan.apps.t.a.awZ().getSwitch(str, 0);
        if (DEBUG) {
            Log.d("SwanApiCostOpt", str + " value : " + i);
        }
        return i == 1;
    }

    public static boolean aEs() {
        return drD;
    }

    public static boolean aEt() {
        return drE;
    }

    public static boolean aEu() {
        return drF;
    }

    public static boolean aEv() {
        return drG;
    }

    public static boolean aEw() {
        return drH;
    }

    public static int aEx() {
        return drI;
    }

    public static boolean aEy() {
        return drJ;
    }

    public static boolean ahk() {
        return drK;
    }

    public static boolean aEz() {
        return drL;
    }
}
