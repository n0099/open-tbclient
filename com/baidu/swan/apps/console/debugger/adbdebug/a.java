package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Environment;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.e.d;
import java.io.File;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static e.f d(com.baidu.swan.apps.v.b.b bVar) {
        File file = new File(Environment.getExternalStorageDirectory() + "/" + b.Xg());
        e.a(file, Xf(), bVar);
        d.deleteFile(file);
        e.f fVar = new e.f();
        File file2 = new File(Xf(), "app.json");
        SwanAppConfigData k = SwanAppConfigData.k(d.readFileData(file2), Xf());
        fVar.clg = Xf().getPath() + File.separator;
        fVar.clh = k;
        if (DEBUG) {
            Log.d("ADBDebugBundleHelper", "configFile path: " + file2.getPath());
            Log.d("ADBDebugBundleHelper", "configFile exist: " + file2.exists());
            Log.d("ADBDebugBundleHelper", "info.mAppBundlePath path: " + fVar.clg);
        }
        return fVar;
    }

    public static File Xf() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_adb_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
