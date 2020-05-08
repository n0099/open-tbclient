package com.baidu.swan.apps.console.debugger.b;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.t.e;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static e.f d(com.baidu.swan.apps.x.b.b bVar) {
        File Ts = Ts();
        e.a(TM(), Ts, bVar);
        e.f fVar = new e.f();
        File file = new File(Ts, "app.json");
        SwanAppConfigData k = SwanAppConfigData.k(com.baidu.swan.d.c.readFileData(file), Ts);
        fVar.bVX = Ts.getPath() + File.separator;
        fVar.bVY = k;
        if (DEBUG) {
            Log.d("WirelessDebugBundleHelper", "configFile path: " + file.getPath());
            Log.d("WirelessDebugBundleHelper", "configFile exist: " + file.exists());
            Log.d("WirelessDebugBundleHelper", "info.mAppBundlePath path: " + fVar.bVX);
        }
        return fVar;
    }

    public static File Ts() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File TM() {
        return new File(TN(), "wireless_debug.aiapps");
    }

    public static File TN() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
