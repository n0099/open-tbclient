package com.baidu.swan.apps.performance.b;

import android.util.Log;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean cVu = mR("swan_get_swan_id_cache");
    private static boolean cVv = mR("swan_update_async");
    private static boolean cVw = com.baidu.swan.apps.t.a.asi().getSwitch("swan_update_async_merge_node", false);
    private static boolean cVx = mR("swan_pre_app_launch");
    private static boolean cVy = mR("swan_prevent_series_launch");
    private static int cVz = com.baidu.swan.apps.t.a.asi().getSwitch("swan_prevent_series_launch_interval", 200);
    private static boolean cVA = mR("swan_pre_class_loader");
    private static boolean cVB = com.baidu.swan.apps.t.a.asi().acD();
    private static boolean cVC = mR("swan_release_runtime_wait_master_finish");

    private static boolean mR(String str) {
        int i = com.baidu.swan.apps.t.a.asi().getSwitch(str, 0);
        if (DEBUG) {
            Log.d("SwanApiCostOpt", str + " value : " + i);
        }
        return i == 1;
    }

    public static boolean azD() {
        return cVu;
    }

    public static boolean azE() {
        return cVv;
    }

    public static boolean azF() {
        return cVw;
    }

    public static boolean azG() {
        return cVx;
    }

    public static boolean azH() {
        return cVy;
    }

    public static int azI() {
        return cVz;
    }

    public static boolean azJ() {
        return cVA;
    }

    public static boolean acD() {
        return cVB;
    }

    public static boolean azK() {
        return cVC;
    }
}
