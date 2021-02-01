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
        List<af.a> list = (List) b.ayH().oB("getStorageListCache");
        if (list == null) {
            List<af.a> storageList = af.getStorageList();
            b.ayH().m("getStorageListCache", storageList);
            return storageList;
        }
        return list;
    }

    public static void i(Boolean bool) {
        b.ayH().m("getNightModeStateCache", bool);
    }

    public static Boolean fS(boolean z) {
        Boolean bool = (Boolean) b.ayH().oB("getNightModeStateCache");
        if (bool == null) {
            return Boolean.valueOf(com.baidu.swan.apps.t.a.axs().aii());
        }
        if (z) {
            b.ayH().oC("getNightModeStateCache");
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
        if (c.aEv()) {
            SwanAppConfigData swanAppConfigData = (SwanAppConfigData) b.ayH().oB(file.getAbsolutePath());
            if (swanAppConfigData == null) {
                SwanAppConfigData z = z(file);
                b.ayH().m(file.getAbsolutePath(), z);
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
