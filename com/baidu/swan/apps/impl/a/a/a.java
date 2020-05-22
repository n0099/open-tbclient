package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.storage.b;
import com.baidu.swan.e.d;
import java.io.File;
/* loaded from: classes11.dex */
public class a {
    public static File ceV = e.aeI();
    public static String ceW = "swan_core";
    public static String ceX = "extension_core";
    public static String ceY = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String ceZ = "cloneFolder_";
    public static String cfa = ceY + File.separator + ceZ;
    public static String cfb = "clone_pkg_folder";
    public static String cfc = "clone_core_folder";
    public static String cfd = "clone_sp_folder";
    public static String cfe = "clone_db_folder";
    public static String cff = "cloneZip.zip";

    public static File aej() {
        File file = new File(b.arw());
        if (d.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
