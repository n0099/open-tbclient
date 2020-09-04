package com.baidu.swan.apps.console.debugger.b;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes8.dex */
public class b {
    public static d.f d(com.baidu.swan.apps.u.c.b bVar) {
        File adR = adR();
        com.baidu.swan.apps.r.d.a(ael(), adR, bVar);
        d.f fVar = new d.f();
        File file = new File(adR, "app.json");
        SwanAppConfigData m = SwanAppConfigData.m(com.baidu.swan.c.d.readFileData(file), adR);
        fVar.cuR = adR.getPath() + File.separator;
        fVar.cuS = m;
        com.baidu.swan.apps.console.c.bb("WirelessDebugBundleHelper", "configFile path: " + file.getPath() + " exist: " + file.exists() + " info.mAppBundlePath path: " + fVar.cuR);
        return fVar;
    }

    public static File adR() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File ael() {
        return new File(aem(), "wireless_debug.aiapps");
    }

    public static File aem() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
