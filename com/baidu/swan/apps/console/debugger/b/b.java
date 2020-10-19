package com.baidu.swan.apps.console.debugger.b;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes10.dex */
public class b {
    public static d.f d(com.baidu.swan.apps.u.c.b bVar) {
        File ahm = ahm();
        com.baidu.swan.apps.r.d.a(ahG(), ahm, bVar);
        d.f fVar = new d.f();
        File file = new File(ahm, "app.json");
        SwanAppConfigData l = SwanAppConfigData.l(com.baidu.swan.c.d.readFileData(file), ahm);
        fVar.cIX = ahm.getPath() + File.separator;
        fVar.cIY = l;
        com.baidu.swan.apps.console.c.bg("WirelessDebugBundleHelper", "configFile path: " + file.getPath() + " exist: " + file.exists() + " info.mAppBundlePath path: " + fVar.cIX);
        return fVar;
    }

    public static File ahm() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File ahG() {
        return new File(ahH(), "wireless_debug.aiapps");
    }

    public static File ahH() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
