package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Environment;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static e.f d(com.baidu.swan.apps.x.b.b bVar) {
        File file = new File(Environment.getExternalStorageDirectory() + "/" + b.Tt());
        e.a(file, Ts(), bVar);
        c.deleteFile(file);
        e.f fVar = new e.f();
        File file2 = new File(Ts(), "app.json");
        SwanAppConfigData k = SwanAppConfigData.k(c.readFileData(file2), Ts());
        fVar.bVX = Ts().getPath() + File.separator;
        fVar.bVY = k;
        if (DEBUG) {
            Log.d("ADBDebugBundleHelper", "configFile path: " + file2.getPath());
            Log.d("ADBDebugBundleHelper", "configFile exist: " + file2.exists());
            Log.d("ADBDebugBundleHelper", "info.mAppBundlePath path: " + fVar.bVX);
        }
        return fVar;
    }

    public static File Ts() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_adb_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
