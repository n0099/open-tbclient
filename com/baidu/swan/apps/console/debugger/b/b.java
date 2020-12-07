package com.baidu.swan.apps.console.debugger.b;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes25.dex */
public class b {
    public static d.f d(com.baidu.swan.apps.u.c.b bVar) {
        File aog = aog();
        com.baidu.swan.apps.r.d.a(aoA(), aog, bVar);
        d.f fVar = new d.f();
        File file = new File(aog, "app.json");
        SwanAppConfigData l = SwanAppConfigData.l(com.baidu.swan.c.d.readFileData(file), aog);
        fVar.dcz = aog.getPath() + File.separator;
        fVar.dcA = l;
        com.baidu.swan.apps.console.c.bt("WirelessDebugBundleHelper", "configFile path: " + file.getPath() + " exist: " + file.exists() + " info.mAppBundlePath path: " + fVar.dcz);
        return fVar;
    }

    public static File aog() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File aoA() {
        return new File(aoB(), "wireless_debug.aiapps");
    }

    public static File aoB() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
