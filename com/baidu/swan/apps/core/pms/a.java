package com.baidu.swan.apps.core.pms;

import android.util.Log;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static boolean Ge() {
        return dl(0) || dl(1);
    }

    public static boolean dl(int i) {
        if (com.baidu.swan.apps.ac.a.a.NS() || dm(i)) {
            if (DEBUG) {
                Log.i("PMSAbTestManager", "Debug 模式-强制命中PMS : " + i);
            }
            return true;
        }
        boolean z = false;
        switch (i) {
            case 0:
                z = com.baidu.swan.apps.u.a.Jl().Bs();
                break;
            case 1:
                z = com.baidu.swan.apps.u.a.Jl().Bt();
                break;
        }
        if (DEBUG) {
            Log.i("PMSAbTestManager", "PMS AB 实验：" + i + " : " + z);
            return z;
        }
        return z;
    }

    public static int Gf() {
        int s = com.baidu.swan.apps.u.a.Jl().s("swan_pms_buffer", 64);
        if (DEBUG) {
            Log.i("PMSAbTestManager", "PMS Buffer size：" + s + "KiB");
        }
        return s * 1024;
    }

    public static boolean dm(int i) {
        return com.baidu.swan.apps.storage.b.f.SR().getBoolean("key_sp_force_pms_for_debug" + i, false);
    }
}
