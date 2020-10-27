package com.baidu.swan.apps.console.debugger.b;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes10.dex */
public class b {
    public static d.f d(com.baidu.swan.apps.u.c.b bVar) {
        File ajg = ajg();
        com.baidu.swan.apps.r.d.a(ajA(), ajg, bVar);
        d.f fVar = new d.f();
        File file = new File(ajg, "app.json");
        SwanAppConfigData l = SwanAppConfigData.l(com.baidu.swan.c.d.readFileData(file), ajg);
        fVar.cRt = ajg.getPath() + File.separator;
        fVar.cRu = l;
        com.baidu.swan.apps.console.c.bn("WirelessDebugBundleHelper", "configFile path: " + file.getPath() + " exist: " + file.exists() + " info.mAppBundlePath path: " + fVar.cRt);
        return fVar;
    }

    public static File ajg() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File ajA() {
        return new File(ajB(), "wireless_debug.aiapps");
    }

    public static File ajB() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
