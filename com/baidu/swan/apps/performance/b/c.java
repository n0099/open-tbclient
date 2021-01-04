package com.baidu.swan.apps.performance.b;

import android.util.Log;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean duh = nT("swan_get_swan_id_cache");
    private static boolean dui = nT("swan_update_async");
    private static boolean duj = com.baidu.swan.apps.t.a.aAu().getSwitch("swan_update_async_merge_node", false);
    private static boolean duk = nT("swan_pre_app_launch");
    private static boolean dul = nT("swan_prevent_series_launch");
    private static int dum = com.baidu.swan.apps.t.a.aAu().getSwitch("swan_prevent_series_launch_interval", 200);
    private static boolean dun = nT("swan_pre_class_loader");
    private static boolean duo = com.baidu.swan.apps.t.a.aAu().akF();
    private static boolean dup = nT("swan_release_runtime_wait_master_finish");

    private static boolean nT(String str) {
        int i = com.baidu.swan.apps.t.a.aAu().getSwitch(str, 0);
        if (DEBUG) {
            Log.d("SwanApiCostOpt", str + " value : " + i);
        }
        return i == 1;
    }

    public static boolean aHQ() {
        return duh;
    }

    public static boolean aHR() {
        return dui;
    }

    public static boolean aHS() {
        return duj;
    }

    public static boolean aHT() {
        return duk;
    }

    public static boolean aHU() {
        return dul;
    }

    public static int aHV() {
        return dum;
    }

    public static boolean aHW() {
        return dun;
    }

    public static boolean akF() {
        return duo;
    }

    public static boolean aHX() {
        return dup;
    }
}
