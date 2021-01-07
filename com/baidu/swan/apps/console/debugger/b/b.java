package com.baidu.swan.apps.console.debugger.b;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes9.dex */
public class b {
    public static d.f d(com.baidu.swan.apps.u.c.b bVar) {
        File apu = apu();
        com.baidu.swan.apps.r.d.a(apO(), apu, bVar);
        d.f fVar = new d.f();
        File file = new File(apu, "app.json");
        SwanAppConfigData o = SwanAppConfigData.o(com.baidu.swan.c.d.readFileData(file), apu);
        fVar.dhs = apu.getPath() + File.separator;
        fVar.dht = o;
        com.baidu.swan.apps.console.c.bs("WirelessDebugBundleHelper", "configFile path: " + file.getPath() + " exist: " + file.exists() + " info.mAppBundlePath path: " + fVar.dhs);
        return fVar;
    }

    public static File apu() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File apO() {
        return new File(apP(), "wireless_debug.aiapps");
    }

    public static File apP() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
