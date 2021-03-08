package com.baidu.swan.apps.u.a;

import android.util.Log;
import com.baidu.swan.apps.ao.af;
import com.baidu.swan.apps.performance.b.c;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
import java.util.List;
/* loaded from: classes8.dex */
public class a implements com.baidu.swan.apps.u.d.a {
    public static List<af.a> getStorageList() {
        List<af.a> list = (List) b.ayK().oI("getStorageListCache");
        if (list == null) {
            List<af.a> storageList = af.getStorageList();
            b.ayK().n("getStorageListCache", storageList);
            return storageList;
        }
        return list;
    }

    public static void i(Boolean bool) {
        b.ayK().n("getNightModeStateCache", bool);
    }

    public static Boolean fS(boolean z) {
        Boolean bool = (Boolean) b.ayK().oI("getNightModeStateCache");
        if (bool == null) {
            return Boolean.valueOf(com.baidu.swan.apps.t.a.axv().ail());
        }
        if (z) {
            b.ayK().oJ("getNightModeStateCache");
            return bool;
        }
        return bool;
    }

    public static SwanAppConfigData z(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SwanAppConfigData o = SwanAppConfigData.o(d.v(new File(file, "app.json")), file);
        if (DEBUG) {
            Log.d("SwanPreProcess", "buildAppJsonConfig cost = " + (System.currentTimeMillis() - currentTimeMillis) + "ms ; current thread = " + Thread.currentThread().getId());
            return o;
        }
        return o;
    }

    public static SwanAppConfigData A(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        if (c.aEy()) {
            SwanAppConfigData swanAppConfigData = (SwanAppConfigData) b.ayK().oI(file.getAbsolutePath());
            if (swanAppConfigData == null) {
                SwanAppConfigData z = z(file);
                b.ayK().n(file.getAbsolutePath(), z);
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
