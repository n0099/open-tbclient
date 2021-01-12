package com.baidu.swan.apps.console.debugger.b;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes8.dex */
public class b {
    public static d.f d(com.baidu.swan.apps.u.c.b bVar) {
        File alz = alz();
        com.baidu.swan.apps.r.d.a(alT(), alz, bVar);
        d.f fVar = new d.f();
        File file = new File(alz, "app.json");
        SwanAppConfigData o = SwanAppConfigData.o(com.baidu.swan.c.d.readFileData(file), alz);
        fVar.dcE = alz.getPath() + File.separator;
        fVar.dcF = o;
        com.baidu.swan.apps.console.c.br("WirelessDebugBundleHelper", "configFile path: " + file.getPath() + " exist: " + file.exists() + " info.mAppBundlePath path: " + fVar.dcE);
        return fVar;
    }

    public static File alz() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File alT() {
        return new File(alU(), "wireless_debug.aiapps");
    }

    public static File alU() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
