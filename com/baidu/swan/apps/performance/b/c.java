package com.baidu.swan.apps.performance.b;

import android.util.Log;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean ddU = nk("swan_get_swan_id_cache");
    private static boolean ddV = nk("swan_update_async");
    private static boolean ddW = com.baidu.swan.apps.t.a.aud().getSwitch("swan_update_async_merge_node", false);
    private static boolean ddX = nk("swan_pre_app_launch");
    private static boolean ddY = nk("swan_prevent_series_launch");
    private static int ddZ = com.baidu.swan.apps.t.a.aud().getSwitch("swan_prevent_series_launch_interval", 200);
    private static boolean dea = nk("swan_pre_class_loader");
    private static boolean deb = com.baidu.swan.apps.t.a.aud().aex();
    private static boolean dec = nk("swan_release_runtime_wait_master_finish");

    private static boolean nk(String str) {
        int i = com.baidu.swan.apps.t.a.aud().getSwitch(str, 0);
        if (DEBUG) {
            Log.d("SwanApiCostOpt", str + " value : " + i);
        }
        return i == 1;
    }

    public static boolean aBx() {
        return ddU;
    }

    public static boolean aBy() {
        return ddV;
    }

    public static boolean aBz() {
        return ddW;
    }

    public static boolean aBA() {
        return ddX;
    }

    public static boolean aBB() {
        return ddY;
    }

    public static int aBC() {
        return ddZ;
    }

    public static boolean aBD() {
        return dea;
    }

    public static boolean aex() {
        return deb;
    }

    public static boolean aBE() {
        return dec;
    }
}
