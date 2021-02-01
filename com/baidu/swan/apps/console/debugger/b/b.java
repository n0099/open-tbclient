package com.baidu.swan.apps.console.debugger.b;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes9.dex */
public class b {
    public static d.f d(com.baidu.swan.apps.u.c.b bVar) {
        File alX = alX();
        com.baidu.swan.apps.r.d.a(amr(), alX, bVar);
        d.f fVar = new d.f();
        File file = new File(alX, "app.json");
        SwanAppConfigData o = SwanAppConfigData.o(com.baidu.swan.c.d.readFileData(file), alX);
        fVar.deR = alX.getPath() + File.separator;
        fVar.deS = o;
        com.baidu.swan.apps.console.c.bl("WirelessDebugBundleHelper", "configFile path: " + file.getPath() + " exist: " + file.exists() + " info.mAppBundlePath path: " + fVar.deR);
        return fVar;
    }

    public static File alX() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File amr() {
        return new File(ams(), "wireless_debug.aiapps");
    }

    public static File ams() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
