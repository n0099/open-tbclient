package com.baidu.swan.apps.console.debugger.b;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes9.dex */
public class b {
    public static d.f d(com.baidu.swan.apps.u.c.b bVar) {
        File apt = apt();
        com.baidu.swan.apps.r.d.a(apN(), apt, bVar);
        d.f fVar = new d.f();
        File file = new File(apt, "app.json");
        SwanAppConfigData o = SwanAppConfigData.o(com.baidu.swan.c.d.readFileData(file), apt);
        fVar.dhs = apt.getPath() + File.separator;
        fVar.dht = o;
        com.baidu.swan.apps.console.c.bs("WirelessDebugBundleHelper", "configFile path: " + file.getPath() + " exist: " + file.exists() + " info.mAppBundlePath path: " + fVar.dhs);
        return fVar;
    }

    public static File apt() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File apN() {
        return new File(apO(), "wireless_debug.aiapps");
    }

    public static File apO() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
