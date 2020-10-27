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
        List<af.a> list = (List) b.avK().oM("getStorageListCache");
        if (list == null) {
            List<af.a> storageList = af.getStorageList();
            b.avK().p("getStorageListCache", storageList);
            return storageList;
        }
        return list;
    }

    public static void h(Boolean bool) {
        b.avK().p("getNightModeStateCache", bool);
    }

    public static Boolean fk(boolean z) {
        Boolean bool = (Boolean) b.avK().oM("getNightModeStateCache");
        if (bool == null) {
            return Boolean.valueOf(com.baidu.swan.apps.t.a.auw().getNightModeSwitcherState());
        }
        if (z) {
            b.avK().oN("getNightModeStateCache");
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
        if (c.aBA()) {
            SwanAppConfigData swanAppConfigData = (SwanAppConfigData) b.avK().oM(file.getAbsolutePath());
            if (swanAppConfigData == null) {
                SwanAppConfigData C = C(file);
                b.avK().p(file.getAbsolutePath(), C);
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
