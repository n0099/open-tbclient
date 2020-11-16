package com.baidu.swan.apps.performance.b;

import android.util.Log;
/* loaded from: classes7.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean dih = nt("swan_get_swan_id_cache");
    private static boolean dii = nt("swan_update_async");
    private static boolean dij = com.baidu.swan.apps.t.a.avV().getSwitch("swan_update_async_merge_node", false);
    private static boolean dik = nt("swan_pre_app_launch");
    private static boolean dil = nt("swan_prevent_series_launch");
    private static int dim = com.baidu.swan.apps.t.a.avV().getSwitch("swan_prevent_series_launch_interval", 200);
    private static boolean din = nt("swan_pre_class_loader");
    private static boolean dio = com.baidu.swan.apps.t.a.avV().agp();
    private static boolean dip = nt("swan_release_runtime_wait_master_finish");

    private static boolean nt(String str) {
        int i = com.baidu.swan.apps.t.a.avV().getSwitch(str, 0);
        if (DEBUG) {
            Log.d("SwanApiCostOpt", str + " value : " + i);
        }
        return i == 1;
    }

    public static boolean aDp() {
        return dih;
    }

    public static boolean aDq() {
        return dii;
    }

    public static boolean aDr() {
        return dij;
    }

    public static boolean aDs() {
        return dik;
    }

    public static boolean aDt() {
        return dil;
    }

    public static int aDu() {
        return dim;
    }

    public static boolean aDv() {
        return din;
    }

    public static boolean agp() {
        return dio;
    }

    public static boolean aDw() {
        return dip;
    }
}
