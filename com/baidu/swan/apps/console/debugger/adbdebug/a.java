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
        File file = new File(Environment.getExternalStorageDirectory() + "/" + b.ahn());
        d.a(file, ahm(), bVar);
        com.baidu.swan.c.d.deleteFile(file);
        d.f fVar = new d.f();
        File file2 = new File(ahm(), "app.json");
        SwanAppConfigData l = SwanAppConfigData.l(com.baidu.swan.c.d.readFileData(file2), ahm());
        fVar.cIX = ahm().getPath() + File.separator;
        fVar.cIY = l;
        c.bg("ADBDebugBundleHelper", "configFile path: " + file2.getPath() + " exist: " + file2.exists() + " info.mAppBundlePath path: " + fVar.cIX);
        return fVar;
    }

    public static File ahm() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_adb_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
