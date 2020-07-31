package com.baidu.swan.apps.console.debugger.b;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static d.f d(com.baidu.swan.apps.u.c.b bVar) {
        File XL = XL();
        com.baidu.swan.apps.r.d.a(Yf(), XL, bVar);
        d.f fVar = new d.f();
        File file = new File(XL, "app.json");
        SwanAppConfigData m = SwanAppConfigData.m(com.baidu.swan.d.d.readFileData(file), XL);
        fVar.cnk = XL.getPath() + File.separator;
        fVar.cnl = m;
        if (DEBUG) {
            Log.d("WirelessDebugBundleHelper", "configFile path: " + file.getPath());
            Log.d("WirelessDebugBundleHelper", "configFile exist: " + file.exists());
            Log.d("WirelessDebugBundleHelper", "info.mAppBundlePath path: " + fVar.cnk);
        }
        return fVar;
    }

    public static File XL() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File Yf() {
        return new File(Yg(), "wireless_debug.aiapps");
    }

    public static File Yg() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
