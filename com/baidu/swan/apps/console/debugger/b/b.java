package com.baidu.swan.apps.console.debugger.b;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes10.dex */
public class b {
    public static d.f d(com.baidu.swan.apps.u.c.b bVar) {
        File alG = alG();
        com.baidu.swan.apps.r.d.a(ama(), alG, bVar);
        d.f fVar = new d.f();
        File file = new File(alG, "app.json");
        SwanAppConfigData l = SwanAppConfigData.l(com.baidu.swan.c.d.readFileData(file), alG);
        fVar.cXm = alG.getPath() + File.separator;
        fVar.cXn = l;
        com.baidu.swan.apps.console.c.bn("WirelessDebugBundleHelper", "configFile path: " + file.getPath() + " exist: " + file.exists() + " info.mAppBundlePath path: " + fVar.cXm);
        return fVar;
    }

    public static File alG() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File ama() {
        return new File(amb(), "wireless_debug.aiapps");
    }

    public static File amb() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
