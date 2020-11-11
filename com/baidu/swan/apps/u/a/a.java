package com.baidu.swan.apps.u.a;

import android.util.Log;
import com.baidu.swan.apps.ap.af;
import com.baidu.swan.apps.performance.b.c;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
import java.util.List;
/* loaded from: classes10.dex */
public class a implements com.baidu.swan.apps.u.d.a {
    public static List<af.a> getStorageList() {
        List<af.a> list = (List) b.ayk().pa("getStorageListCache");
        if (list == null) {
            List<af.a> storageList = af.getStorageList();
            b.ayk().p("getStorageListCache", storageList);
            return storageList;
        }
        return list;
    }

    public static void h(Boolean bool) {
        b.ayk().p("getNightModeStateCache", bool);
    }

    public static Boolean ft(boolean z) {
        Boolean bool = (Boolean) b.ayk().pa("getNightModeStateCache");
        if (bool == null) {
            return Boolean.valueOf(com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState());
        }
        if (z) {
            b.ayk().pb("getNightModeStateCache");
            return bool;
        }
        return bool;
    }

    public static SwanAppConfigData C(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SwanAppConfigData l = SwanAppConfigData.l(d.y(new File(file, "app.json")), file);
        if (DEBUG) {
            Log.d("SwanPreProcess", "buildAppJsonConfig cost = " + (System.currentTimeMillis() - currentTimeMillis) + "ms ; current thread = " + Thread.currentThread().getId());
            return l;
        }
        return l;
    }

    public static SwanAppConfigData D(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        if (c.aEa()) {
            SwanAppConfigData swanAppConfigData = (SwanAppConfigData) b.ayk().pa(file.getAbsolutePath());
            if (swanAppConfigData == null) {
                SwanAppConfigData C = C(file);
                b.ayk().p(file.getAbsolutePath(), C);
                return C;
            } else if (DEBUG) {
                Log.d("SwanPreProcess", "adopt cached app.json");
                return swanAppConfigData;
            } else {
                return swanAppConfigData;
            }
        }
        return C(file);
    }
}
