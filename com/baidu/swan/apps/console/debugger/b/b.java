package com.baidu.swan.apps.console.debugger.b;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes7.dex */
public class b {
    public static d.f d(com.baidu.swan.apps.u.c.b bVar) {
        File akY = akY();
        com.baidu.swan.apps.r.d.a(als(), akY, bVar);
        d.f fVar = new d.f();
        File file = new File(akY, "app.json");
        SwanAppConfigData l = SwanAppConfigData.l(com.baidu.swan.c.d.readFileData(file), akY);
        fVar.cVC = akY.getPath() + File.separator;
        fVar.cVD = l;
        com.baidu.swan.apps.console.c.bm("WirelessDebugBundleHelper", "configFile path: " + file.getPath() + " exist: " + file.exists() + " info.mAppBundlePath path: " + fVar.cVC);
        return fVar;
    }

    public static File akY() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File als() {
        return new File(alt(), "wireless_debug.aiapps");
    }

    public static File alt() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
