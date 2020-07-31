package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Environment;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static d.f d(com.baidu.swan.apps.u.c.b bVar) {
        File file = new File(Environment.getExternalStorageDirectory() + "/" + b.XM());
        d.a(file, XL(), bVar);
        com.baidu.swan.d.d.deleteFile(file);
        d.f fVar = new d.f();
        File file2 = new File(XL(), "app.json");
        SwanAppConfigData m = SwanAppConfigData.m(com.baidu.swan.d.d.readFileData(file2), XL());
        fVar.cnk = XL().getPath() + File.separator;
        fVar.cnl = m;
        if (DEBUG) {
            Log.d("ADBDebugBundleHelper", "configFile path: " + file2.getPath());
            Log.d("ADBDebugBundleHelper", "configFile exist: " + file2.exists());
            Log.d("ADBDebugBundleHelper", "info.mAppBundlePath path: " + fVar.cnk);
        }
        return fVar;
    }

    public static File XL() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_adb_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
