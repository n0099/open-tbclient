package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Environment;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes10.dex */
public class a {
    public static d.f d(com.baidu.swan.apps.u.c.b bVar) {
        File file = new File(Environment.getExternalStorageDirectory() + "/" + b.alH());
        d.a(file, alG(), bVar);
        com.baidu.swan.c.d.deleteFile(file);
        d.f fVar = new d.f();
        File file2 = new File(alG(), "app.json");
        SwanAppConfigData l = SwanAppConfigData.l(com.baidu.swan.c.d.readFileData(file2), alG());
        fVar.cXm = alG().getPath() + File.separator;
        fVar.cXn = l;
        c.bn("ADBDebugBundleHelper", "configFile path: " + file2.getPath() + " exist: " + file2.exists() + " info.mAppBundlePath path: " + fVar.cXm);
        return fVar;
    }

    public static File alG() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_adb_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
