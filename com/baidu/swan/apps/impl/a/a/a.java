package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.storage.b;
import java.io.File;
/* loaded from: classes9.dex */
public class a {
    public static File dfF = d.aAi();
    public static String dfG = "swan_core";
    public static String dfH = "extension_core";
    public static String dfI = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String dfJ = "cloneFolder_";
    public static String dfK = dfI + File.separator + dfJ;
    public static String dfL = "clone_pkg_folder";
    public static String dfM = "clone_core_folder";
    public static String dfN = "clone_dynamic_lib_folder";
    public static String dfO = "clone_sp_folder";
    public static String dfP = "clone_db_folder";
    public static String dfQ = "cloneZip.zip";
    public static String dfR = "clone_zipFiles";

    public static File azr() {
        File file = new File(b.aPq());
        if (com.baidu.swan.c.d.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
