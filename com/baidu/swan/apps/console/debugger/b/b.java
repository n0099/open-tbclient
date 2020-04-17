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
        File Tt = Tt();
        e.a(TN(), Tt, bVar);
        e.f fVar = new e.f();
        File file = new File(Tt, "app.json");
        SwanAppConfigData k = SwanAppConfigData.k(com.baidu.swan.d.c.readFileData(file), Tt);
        fVar.bVR = Tt.getPath() + File.separator;
        fVar.bVS = k;
        if (DEBUG) {
            Log.d("WirelessDebugBundleHelper", "configFile path: " + file.getPath());
            Log.d("WirelessDebugBundleHelper", "configFile exist: " + file.exists());
            Log.d("WirelessDebugBundleHelper", "info.mAppBundlePath path: " + fVar.bVR);
        }
        return fVar;
    }

    public static File Tt() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File TN() {
        return new File(TO(), "wireless_debug.aiapps");
    }

    public static File TO() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
