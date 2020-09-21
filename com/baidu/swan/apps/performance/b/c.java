package com.baidu.swan.apps.performance.b;

import android.util.Log;
/* loaded from: classes3.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean cJr = mf("swan_get_swan_id_cache");
    private static boolean cJs = mf("swan_update_async");
    private static boolean cJt = com.baidu.swan.apps.t.a.apx().getSwitch("swan_update_async_merge_node", false);
    private static boolean cJu = mf("swan_pre_app_launch");
    private static boolean cJv = mf("swan_prevent_series_launch");
    private static int cJw = com.baidu.swan.apps.t.a.apx().getSwitch("swan_prevent_series_launch_interval", 200);
    private static boolean cJx = mf("swan_pre_class_loader");
    private static boolean cJy = com.baidu.swan.apps.t.a.apx().ZR();
    private static boolean cJz = mf("swan_release_runtime_wait_master_finish");

    private static boolean mf(String str) {
        int i = com.baidu.swan.apps.t.a.apx().getSwitch(str, 0);
        if (DEBUG) {
            Log.d("SwanApiCostOpt", str + " value : " + i);
        }
        return i == 1;
    }

    public static boolean awS() {
        return cJr;
    }

    public static boolean awT() {
        return cJs;
    }

    public static boolean awU() {
        return cJt;
    }

    public static boolean awV() {
        return cJu;
    }

    public static boolean awW() {
        return cJv;
    }

    public static int awX() {
        return cJw;
    }

    public static boolean awY() {
        return cJx;
    }

    public static boolean ZR() {
        return cJy;
    }

    public static boolean awZ() {
        return cJz;
    }
}
