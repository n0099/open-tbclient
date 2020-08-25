package com.baidu.swan.apps.u.a;

import android.util.Log;
import com.baidu.swan.apps.ap.af;
import com.baidu.swan.apps.performance.b.c;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
import java.util.List;
/* loaded from: classes8.dex */
public class a implements com.baidu.swan.apps.u.d.a {
    public static List<af.a> getStorageList() {
        List<af.a> list = (List) b.aqu().nl("getStorageListCache");
        if (list == null) {
            List<af.a> storageList = af.getStorageList();
            b.aqu().p("getStorageListCache", storageList);
            return storageList;
        }
        return list;
    }

    public static void g(Boolean bool) {
        b.aqu().p("getNightModeStateCache", bool);
    }

    public static Boolean eC(boolean z) {
        Boolean bool = (Boolean) b.aqu().nl("getNightModeStateCache");
        if (bool == null) {
            return Boolean.valueOf(com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState());
        }
        if (z) {
            b.aqu().nm("getNightModeStateCache");
            return bool;
        }
        return bool;
    }

    public static SwanAppConfigData z(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SwanAppConfigData m = SwanAppConfigData.m(d.v(new File(file, "app.json")), file);
        if (DEBUG) {
            Log.d("SwanPreProcess", "buildAppJsonConfig cost = " + (System.currentTimeMillis() - currentTimeMillis) + "ms ; current thread = " + Thread.currentThread().getId());
            return m;
        }
        return m;
    }

    public static SwanAppConfigData A(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        if (c.awm()) {
            SwanAppConfigData swanAppConfigData = (SwanAppConfigData) b.aqu().nl(file.getAbsolutePath());
            if (swanAppConfigData == null) {
                SwanAppConfigData z = z(file);
                b.aqu().p(file.getAbsolutePath(), z);
                return z;
            } else if (DEBUG) {
                Log.d("SwanPreProcess", "adopt cached app.json");
                return swanAppConfigData;
            } else {
                return swanAppConfigData;
            }
        }
        return z(file);
    }
}
