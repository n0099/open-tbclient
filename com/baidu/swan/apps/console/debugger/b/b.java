package com.baidu.swan.apps.console.debugger.b;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes3.dex */
public class b {
    public static d.f d(com.baidu.swan.apps.u.c.b bVar) {
        File aeB = aeB();
        com.baidu.swan.apps.r.d.a(aeV(), aeB, bVar);
        d.f fVar = new d.f();
        File file = new File(aeB, "app.json");
        SwanAppConfigData m = SwanAppConfigData.m(com.baidu.swan.c.d.readFileData(file), aeB);
        fVar.cwS = aeB.getPath() + File.separator;
        fVar.cwT = m;
        com.baidu.swan.apps.console.c.bb("WirelessDebugBundleHelper", "configFile path: " + file.getPath() + " exist: " + file.exists() + " info.mAppBundlePath path: " + fVar.cwS);
        return fVar;
    }

    public static File aeB() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File aeV() {
        return new File(aeW(), "wireless_debug.aiapps");
    }

    public static File aeW() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
