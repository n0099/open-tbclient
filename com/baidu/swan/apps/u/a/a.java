package com.baidu.swan.apps.u.a;

import android.util.Log;
import com.baidu.swan.apps.ao.af;
import com.baidu.swan.apps.performance.b.c;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
import java.util.List;
/* loaded from: classes9.dex */
public class a implements com.baidu.swan.apps.u.d.a {
    public static List<af.a> getStorageList() {
        List<af.a> list = (List) b.aCc().pu("getStorageListCache");
        if (list == null) {
            List<af.a> storageList = af.getStorageList();
            b.aCc().o("getStorageListCache", storageList);
            return storageList;
        }
        return list;
    }

    public static void i(Boolean bool) {
        b.aCc().o("getNightModeStateCache", bool);
    }

    public static Boolean fU(boolean z) {
        Boolean bool = (Boolean) b.aCc().pu("getNightModeStateCache");
        if (bool == null) {
            return Boolean.valueOf(com.baidu.swan.apps.t.a.aAN().alD());
        }
        if (z) {
            b.aCc().pv("getNightModeStateCache");
            return bool;
        }
        return bool;
    }

    public static SwanAppConfigData E(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SwanAppConfigData o = SwanAppConfigData.o(d.A(new File(file, "app.json")), file);
        if (DEBUG) {
            Log.d("SwanPreProcess", "buildAppJsonConfig cost = " + (System.currentTimeMillis() - currentTimeMillis) + "ms ; current thread = " + Thread.currentThread().getId());
            return o;
        }
        return o;
    }

    public static SwanAppConfigData F(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        if (c.aHT()) {
            SwanAppConfigData swanAppConfigData = (SwanAppConfigData) b.aCc().pu(file.getAbsolutePath());
            if (swanAppConfigData == null) {
                SwanAppConfigData E = E(file);
                b.aCc().o(file.getAbsolutePath(), E);
                return E;
            } else if (DEBUG) {
                Log.d("SwanPreProcess", "adopt cached app.json");
                return swanAppConfigData;
            } else {
                return swanAppConfigData;
            }
        }
        return E(file);
    }
}
