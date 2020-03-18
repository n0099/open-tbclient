package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.storage.b;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes11.dex */
public class a {
    public static File bwt = e.TQ();
    public static String bwu = "swan_core";
    public static String bwv = "extension_core";
    public static String bww = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String bwx = "cloneFolder_";
    public static String bwy = bww + File.separator + bwx;
    public static String bwz = "clone_pkg_folder";
    public static String bwA = "clone_core_folder";
    public static String bwB = "clone_sp_folder";
    public static String bwC = "clone_db_folder";
    public static String bwD = "cloneZip.zip";

    public static File Tu() {
        File file = new File(b.afj());
        if (c.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
