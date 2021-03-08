package com.baidu.swan.apps.console.debugger.b;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes8.dex */
public class b {
    public static d.f d(com.baidu.swan.apps.u.c.b bVar) {
        File ama = ama();
        com.baidu.swan.apps.r.d.a(amu(), ama, bVar);
        d.f fVar = new d.f();
        File file = new File(ama, "app.json");
        SwanAppConfigData o = SwanAppConfigData.o(com.baidu.swan.c.d.readFileData(file), ama);
        fVar.dgs = ama.getPath() + File.separator;
        fVar.dgt = o;
        com.baidu.swan.apps.console.c.bl("WirelessDebugBundleHelper", "configFile path: " + file.getPath() + " exist: " + file.exists() + " info.mAppBundlePath path: " + fVar.dgs);
        return fVar;
    }

    public static File ama() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File amu() {
        return new File(amv(), "wireless_debug.aiapps");
    }

    public static File amv() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
