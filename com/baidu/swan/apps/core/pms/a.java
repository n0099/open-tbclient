package com.baidu.swan.apps.core.pms;

import android.util.Log;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static boolean Bf() {
        return co(0) || co(1);
    }

    public static boolean co(int i) {
        if (com.baidu.swan.apps.ac.a.a.IU() || cp(i)) {
            if (DEBUG) {
                Log.i("PMSAbTestManager", "Debug 模式-强制命中PMS : " + i);
            }
            return true;
        }
        boolean z = false;
        switch (i) {
            case 0:
                z = com.baidu.swan.apps.u.a.En().wu();
                break;
            case 1:
                z = com.baidu.swan.apps.u.a.En().wv();
                break;
        }
        if (DEBUG) {
            Log.i("PMSAbTestManager", "PMS AB 实验：" + i + " : " + z);
            return z;
        }
        return z;
    }

    public static int Bg() {
        int s = com.baidu.swan.apps.u.a.En().s("swan_pms_buffer", 64);
        if (DEBUG) {
            Log.i("PMSAbTestManager", "PMS Buffer size：" + s + "KiB");
        }
        return s * 1024;
    }

    public static boolean cp(int i) {
        return com.baidu.swan.apps.storage.b.f.NX().getBoolean("key_sp_force_pms_for_debug" + i, false);
    }
}
