package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Environment;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes9.dex */
public class a {
    public static d.f d(com.baidu.swan.apps.u.c.b bVar) {
        File file = new File(Environment.getExternalStorageDirectory() + "/" + b.apu());
        d.a(file, apt(), bVar);
        com.baidu.swan.c.d.deleteFile(file);
        d.f fVar = new d.f();
        File file2 = new File(apt(), "app.json");
        SwanAppConfigData o = SwanAppConfigData.o(com.baidu.swan.c.d.readFileData(file2), apt());
        fVar.dhs = apt().getPath() + File.separator;
        fVar.dht = o;
        c.bs("ADBDebugBundleHelper", "configFile path: " + file2.getPath() + " exist: " + file2.exists() + " info.mAppBundlePath path: " + fVar.dhs);
        return fVar;
    }

    public static File apt() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_adb_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
