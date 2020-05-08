package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.storage.b;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes11.dex */
public class a {
    public static File bUF = e.abE();
    public static String bUG = "swan_core";
    public static String bUH = "extension_core";
    public static String bUI = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String bUJ = "cloneFolder_";
    public static String bUK = bUI + File.separator + bUJ;
    public static String bUL = "clone_pkg_folder";
    public static String bUM = "clone_core_folder";
    public static String bUN = "clone_sp_folder";
    public static String bUO = "clone_db_folder";
    public static String bUP = "cloneZip.zip";

    public static File abi() {
        File file = new File(b.ann());
        if (c.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
