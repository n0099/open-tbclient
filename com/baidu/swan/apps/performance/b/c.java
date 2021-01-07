package com.baidu.swan.apps.performance.b;

import android.util.Log;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean duh = nT("swan_get_swan_id_cache");
    private static boolean dui = nT("swan_update_async");
    private static boolean duj = com.baidu.swan.apps.t.a.aAv().getSwitch("swan_update_async_merge_node", false);
    private static boolean duk = nT("swan_pre_app_launch");
    private static boolean dul = nT("swan_prevent_series_launch");
    private static int dum = com.baidu.swan.apps.t.a.aAv().getSwitch("swan_prevent_series_launch_interval", 200);
    private static boolean dun = nT("swan_pre_class_loader");
    private static boolean duo = com.baidu.swan.apps.t.a.aAv().akG();
    private static boolean dup = nT("swan_release_runtime_wait_master_finish");

    private static boolean nT(String str) {
        int i = com.baidu.swan.apps.t.a.aAv().getSwitch(str, 0);
        if (DEBUG) {
            Log.d("SwanApiCostOpt", str + " value : " + i);
        }
        return i == 1;
    }

    public static boolean aHR() {
        return duh;
    }

    public static boolean aHS() {
        return dui;
    }

    public static boolean aHT() {
        return duj;
    }

    public static boolean aHU() {
        return duk;
    }

    public static boolean aHV() {
        return dul;
    }

    public static int aHW() {
        return dum;
    }

    public static boolean aHX() {
        return dun;
    }

    public static boolean akG() {
        return duo;
    }

    public static boolean aHY() {
        return dup;
    }
}
