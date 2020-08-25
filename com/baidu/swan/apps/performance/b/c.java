package com.baidu.swan.apps.performance.b;

import android.util.Log;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean cHn = lL("swan_get_swan_id_cache");
    private static boolean cHo = lL("swan_update_async");
    private static boolean cHp = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_update_async_merge_node", false);
    private static boolean cHq = lL("swan_pre_app_launch");
    private static boolean cHr = lL("swan_prevent_series_launch");
    private static int cHs = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_prevent_series_launch_interval", 200);
    private static boolean cHt = lL("swan_pre_class_loader");
    private static boolean cHu = com.baidu.swan.apps.t.a.aoM().Zi();
    private static boolean cHv = lL("swan_release_runtime_wait_master_finish");

    private static boolean lL(String str) {
        int i = com.baidu.swan.apps.t.a.aoM().getSwitch(str, 0);
        if (DEBUG) {
            Log.d("SwanApiCostOpt", str + " value : " + i);
        }
        return i == 1;
    }

    public static boolean awj() {
        return cHn;
    }

    public static boolean awk() {
        return cHo;
    }

    public static boolean awl() {
        return cHp;
    }

    public static boolean awm() {
        return cHq;
    }

    public static boolean awn() {
        return cHr;
    }

    public static int awo() {
        return cHs;
    }

    public static boolean awp() {
        return cHt;
    }

    public static boolean Zi() {
        return cHu;
    }

    public static boolean awq() {
        return cHv;
    }
}
