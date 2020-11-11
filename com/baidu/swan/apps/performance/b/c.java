package com.baidu.swan.apps.performance.b;

import android.util.Log;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean djQ = nz("swan_get_swan_id_cache");
    private static boolean djR = nz("swan_update_async");
    private static boolean djS = com.baidu.swan.apps.t.a.awD().getSwitch("swan_update_async_merge_node", false);
    private static boolean djT = nz("swan_pre_app_launch");
    private static boolean djU = nz("swan_prevent_series_launch");
    private static int djV = com.baidu.swan.apps.t.a.awD().getSwitch("swan_prevent_series_launch_interval", 200);
    private static boolean djW = nz("swan_pre_class_loader");
    private static boolean djX = com.baidu.swan.apps.t.a.awD().agX();
    private static boolean djY = nz("swan_release_runtime_wait_master_finish");

    private static boolean nz(String str) {
        int i = com.baidu.swan.apps.t.a.awD().getSwitch(str, 0);
        if (DEBUG) {
            Log.d("SwanApiCostOpt", str + " value : " + i);
        }
        return i == 1;
    }

    public static boolean aDX() {
        return djQ;
    }

    public static boolean aDY() {
        return djR;
    }

    public static boolean aDZ() {
        return djS;
    }

    public static boolean aEa() {
        return djT;
    }

    public static boolean aEb() {
        return djU;
    }

    public static int aEc() {
        return djV;
    }

    public static boolean aEd() {
        return djW;
    }

    public static boolean agX() {
        return djX;
    }

    public static boolean aEe() {
        return djY;
    }
}
