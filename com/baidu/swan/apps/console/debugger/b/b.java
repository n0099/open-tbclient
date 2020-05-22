package com.baidu.swan.apps.console.debugger.b;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static e.f d(com.baidu.swan.apps.v.b.b bVar) {
        File VZ = VZ();
        e.a(Wt(), VZ, bVar);
        e.f fVar = new e.f();
        File file = new File(VZ, "app.json");
        SwanAppConfigData k = SwanAppConfigData.k(com.baidu.swan.e.d.readFileData(file), VZ);
        fVar.cgs = VZ.getPath() + File.separator;
        fVar.cgt = k;
        if (DEBUG) {
            Log.d("WirelessDebugBundleHelper", "configFile path: " + file.getPath());
            Log.d("WirelessDebugBundleHelper", "configFile exist: " + file.exists());
            Log.d("WirelessDebugBundleHelper", "info.mAppBundlePath path: " + fVar.cgs);
        }
        return fVar;
    }

    public static File VZ() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File Wt() {
        return new File(Wu(), "wireless_debug.aiapps");
    }

    public static File Wu() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
