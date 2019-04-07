package com.baidu.swan.apps.core.pms;

import android.util.Log;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static boolean vp() {
        if (DEBUG && zv()) {
            Log.i("PMSAbTestManager", "Debug 模式-强制命中PMS");
            return true;
        }
        boolean vp = com.baidu.swan.apps.u.a.Cz().vp();
        if (DEBUG) {
            Log.i("PMSAbTestManager", "PMS AB 实验：" + vp);
            return vp;
        }
        return vp;
    }

    public static boolean zv() {
        return com.baidu.swan.apps.storage.b.f.KJ().getBoolean("key_sp_force_pms_for_debug", false);
    }
}
