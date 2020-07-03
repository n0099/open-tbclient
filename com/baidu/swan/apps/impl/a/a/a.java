package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.storage.b;
import com.baidu.swan.e.d;
import java.io.File;
/* loaded from: classes11.dex */
public class a {
    public static File cjJ = e.afO();
    public static String cjK = "swan_core";
    public static String cjL = "extension_core";
    public static String cjM = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String cjN = "cloneFolder_";
    public static String cjO = cjM + File.separator + cjN;
    public static String cjP = "clone_pkg_folder";
    public static String cjQ = "clone_core_folder";
    public static String cjR = "clone_sp_folder";
    public static String cjS = "clone_db_folder";
    public static String cjT = "cloneZip.zip";

    public static File afp() {
        File file = new File(b.asD());
        if (d.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
