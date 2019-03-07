package com.baidu.swan.apps.core.pms;

import android.util.Log;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;

    public static boolean vq() {
        if (DEBUG && zw()) {
            Log.i("PMSAbTestManager", "Debug 模式-强制命中PMS");
            return true;
        }
        boolean vq = com.baidu.swan.apps.u.a.CB().vq();
        if (DEBUG) {
            Log.i("PMSAbTestManager", "PMS AB 实验：" + vq);
            return vq;
        }
        return vq;
    }

    public static boolean zw() {
        return com.baidu.swan.apps.storage.b.f.KL().getBoolean("key_sp_force_pms_for_debug", false);
    }
}
