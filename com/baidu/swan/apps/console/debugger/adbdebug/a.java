package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Environment;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static e.f d(com.baidu.swan.apps.x.b.b bVar) {
        File file = new File(Environment.getExternalStorageDirectory() + "/" + b.Jm());
        e.a(file, Jl(), bVar);
        c.deleteFile(file);
        e.f fVar = new e.f();
        File file2 = new File(Jl(), "app.json");
        SwanAppConfigData l = SwanAppConfigData.l(c.readFileData(file2), Jl());
        fVar.bto = Jl().getPath() + File.separator;
        fVar.btp = l;
        if (DEBUG) {
            Log.d("ADBDebugBundleHelper", "configFile path: " + file2.getPath());
            Log.d("ADBDebugBundleHelper", "configFile exist: " + file2.exists());
            Log.d("ADBDebugBundleHelper", "info.mAppBundlePath path: " + fVar.bto);
        }
        return fVar;
    }

    public static File Jl() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_adb_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
