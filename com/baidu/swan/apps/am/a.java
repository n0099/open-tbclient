package com.baidu.swan.apps.am;

import android.util.Log;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.database.SwanAppDbControl;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    public static void G(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.Bm().B(i, i2);
        if (i != i2) {
            cm(true);
        }
    }

    public static void cm(boolean z) {
        if (DEBUG) {
            Log.i("SwanAppUpgradeManager", "set firstStart flag for aiapps when BaiDu app update finished");
        }
        j.c(new Runnable() { // from class: com.baidu.swan.apps.am.a.1
            @Override // java.lang.Runnable
            public void run() {
                boolean f = SwanAppDbControl.bE(com.baidu.swan.apps.u.a.Cw()).f(true, true);
                if (a.DEBUG) {
                    Log.d("SwanAppUpgradeManager", "updateLocalSwanApp firstStartFlag result: " + f);
                }
            }
        }, "update all local aiapps firstStart flag");
    }
}
