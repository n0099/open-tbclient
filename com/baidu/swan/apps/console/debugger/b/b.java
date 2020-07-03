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
        File Xf = Xf();
        e.a(Xz(), Xf, bVar);
        e.f fVar = new e.f();
        File file = new File(Xf, "app.json");
        SwanAppConfigData k = SwanAppConfigData.k(com.baidu.swan.e.d.readFileData(file), Xf);
        fVar.clg = Xf.getPath() + File.separator;
        fVar.clh = k;
        if (DEBUG) {
            Log.d("WirelessDebugBundleHelper", "configFile path: " + file.getPath());
            Log.d("WirelessDebugBundleHelper", "configFile exist: " + file.exists());
            Log.d("WirelessDebugBundleHelper", "info.mAppBundlePath path: " + fVar.clg);
        }
        return fVar;
    }

    public static File Xf() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File Xz() {
        return new File(XA(), "wireless_debug.aiapps");
    }

    public static File XA() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
