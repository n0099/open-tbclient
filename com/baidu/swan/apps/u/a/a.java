package com.baidu.swan.apps.u.a;

import android.util.Log;
import com.baidu.swan.apps.ap.af;
import com.baidu.swan.apps.performance.b.c;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
import java.util.List;
/* loaded from: classes25.dex */
public class a implements com.baidu.swan.apps.u.d.a {
    public static List<af.a> getStorageList() {
        List<af.a> list = (List) b.aAL().pB("getStorageListCache");
        if (list == null) {
            List<af.a> storageList = af.getStorageList();
            b.aAL().o("getStorageListCache", storageList);
            return storageList;
        }
        return list;
    }

    public static void h(Boolean bool) {
        b.aAL().o("getNightModeStateCache", bool);
    }

    public static Boolean fL(boolean z) {
        Boolean bool = (Boolean) b.aAL().pB("getNightModeStateCache");
        if (bool == null) {
            return Boolean.valueOf(com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState());
        }
        if (z) {
            b.aAL().pC("getNightModeStateCache");
            return bool;
        }
        return bool;
    }

    public static SwanAppConfigData B(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SwanAppConfigData l = SwanAppConfigData.l(d.x(new File(file, "app.json")), file);
        if (DEBUG) {
            Log.d("SwanPreProcess", "buildAppJsonConfig cost = " + (System.currentTimeMillis() - currentTimeMillis) + "ms ; current thread = " + Thread.currentThread().getId());
            return l;
        }
        return l;
    }

    public static SwanAppConfigData C(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        if (c.aGA()) {
            SwanAppConfigData swanAppConfigData = (SwanAppConfigData) b.aAL().pB(file.getAbsolutePath());
            if (swanAppConfigData == null) {
                SwanAppConfigData B = B(file);
                b.aAL().o(file.getAbsolutePath(), B);
                return B;
            } else if (DEBUG) {
                Log.d("SwanPreProcess", "adopt cached app.json");
                return swanAppConfigData;
            } else {
                return swanAppConfigData;
            }
        }
        return B(file);
    }
}
