package com.baidu.swan.apps.core.pms;

import android.util.Log;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static boolean Bj() {
        return cp(0) || cp(1);
    }

    public static boolean cp(int i) {
        if (com.baidu.swan.apps.ac.a.a.IY() || cq(i)) {
            if (DEBUG) {
                Log.i("PMSAbTestManager", "Debug 模式-强制命中PMS : " + i);
            }
            return true;
        }
        boolean z = false;
        switch (i) {
            case 0:
                z = com.baidu.swan.apps.u.a.Er().wy();
                break;
            case 1:
                z = com.baidu.swan.apps.u.a.Er().wz();
                break;
        }
        if (DEBUG) {
            Log.i("PMSAbTestManager", "PMS AB 实验：" + i + " : " + z);
            return z;
        }
        return z;
    }

    public static int Bk() {
        int s = com.baidu.swan.apps.u.a.Er().s("swan_pms_buffer", 64);
        if (DEBUG) {
            Log.i("PMSAbTestManager", "PMS Buffer size：" + s + "KiB");
        }
        return s * 1024;
    }

    public static boolean cq(int i) {
        return com.baidu.swan.apps.storage.b.f.Ob().getBoolean("key_sp_force_pms_for_debug" + i, false);
    }
}
