package com.baidu.swan.apps.u.a;

import com.baidu.swan.apps.aq.af;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static List<af.a> getStorageList() {
        List<af.a> list = (List) b.aiO().lo("getStorageListCache");
        if (list == null) {
            List<af.a> storageList = af.getStorageList();
            b.aiO().p("getStorageListCache", storageList);
            return storageList;
        }
        return list;
    }

    public static void e(Boolean bool) {
        b.aiO().p("getNightModeStateCache", bool);
    }

    public static Boolean ek(boolean z) {
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            Boolean bool = (Boolean) b.aiO().lo("getNightModeStateCache");
            if (bool == null) {
                return Boolean.valueOf(com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState());
            }
            if (z) {
                b.aiO().lp("getNightModeStateCache");
                return bool;
            }
            return bool;
        }
        return Boolean.valueOf(com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState());
    }

    public static SwanAppConfigData y(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        return SwanAppConfigData.m(d.u(new File(file, "app.json")), file);
    }

    public static SwanAppConfigData z(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            SwanAppConfigData swanAppConfigData = (SwanAppConfigData) b.aiO().lo(file.getAbsolutePath());
            if (swanAppConfigData == null) {
                SwanAppConfigData y = y(file);
                b.aiO().p(file.getAbsolutePath(), y);
                return y;
            }
            return swanAppConfigData;
        }
        return y(file);
    }
}
