package com.baidu.swan.apps.am;

import android.util.Log;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.database.SwanAppDbControl;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static int bsu = 0;

    public static void L(int i, int i2) {
        com.baidu.swan.apps.extcore.cores.a.HX().G(i, i2);
        if (i == 0) {
            bsu = 2;
        } else if (i2 > i) {
            bsu = 1;
        }
        if (i != i2) {
            cV(true);
        }
    }

    public static int TV() {
        return bsu;
    }

    public static void cV(boolean z) {
        if (DEBUG) {
            Log.i("SwanAppUpgradeManager", "set firstStart flag for aiapps when BaiDu app update finished");
        }
        j.c(new Runnable() { // from class: com.baidu.swan.apps.am.a.1
            @Override // java.lang.Runnable
            public void run() {
                boolean j = SwanAppDbControl.aZ(com.baidu.swan.apps.u.a.Jj()).j(true, true);
                if (a.DEBUG) {
                    Log.d("SwanAppUpgradeManager", "updateLocalSwanApp firstStartFlag result: " + j);
                }
            }
        }, "update all local aiapps firstStart flag");
    }
}
