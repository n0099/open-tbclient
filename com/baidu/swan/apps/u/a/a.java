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
        List<af.a> list = (List) b.ayj().oi("getStorageListCache");
        if (list == null) {
            List<af.a> storageList = af.getStorageList();
            b.ayj().o("getStorageListCache", storageList);
            return storageList;
        }
        return list;
    }

    public static void i(Boolean bool) {
        b.ayj().o("getNightModeStateCache", bool);
    }

    public static Boolean fQ(boolean z) {
        Boolean bool = (Boolean) b.ayj().oi("getNightModeStateCache");
        if (bool == null) {
            return Boolean.valueOf(com.baidu.swan.apps.t.a.awU().ahK());
        }
        if (z) {
            b.ayj().oj("getNightModeStateCache");
            return bool;
        }
        return bool;
    }

    public static SwanAppConfigData D(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SwanAppConfigData o = SwanAppConfigData.o(d.z(new File(file, "app.json")), file);
        if (DEBUG) {
            Log.d("SwanPreProcess", "buildAppJsonConfig cost = " + (System.currentTimeMillis() - currentTimeMillis) + "ms ; current thread = " + Thread.currentThread().getId());
            return o;
        }
        return o;
    }

    public static SwanAppConfigData E(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        if (c.aEa()) {
            SwanAppConfigData swanAppConfigData = (SwanAppConfigData) b.ayj().oi(file.getAbsolutePath());
            if (swanAppConfigData == null) {
                SwanAppConfigData D = D(file);
                b.ayj().o(file.getAbsolutePath(), D);
                return D;
            } else if (DEBUG) {
                Log.d("SwanPreProcess", "adopt cached app.json");
                return swanAppConfigData;
            } else {
                return swanAppConfigData;
            }
        }
        return D(file);
    }
}
