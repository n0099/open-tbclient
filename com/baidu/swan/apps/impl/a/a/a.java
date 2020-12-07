package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.storage.b;
import java.io.File;
/* loaded from: classes25.dex */
public class a {
    public static File daK = d.ayQ();
    public static String daL = "swan_core";
    public static String daM = "extension_core";
    public static String daN = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String daO = "cloneFolder_";
    public static String daP = daN + File.separator + daO;
    public static String daQ = "clone_pkg_folder";
    public static String daR = "clone_core_folder";
    public static String daS = "clone_dynamic_lib_folder";
    public static String daT = "clone_sp_folder";
    public static String daU = "clone_db_folder";
    public static String daV = "cloneZip.zip";
    public static String daW = "clone_zipFiles";

    public static File axZ() {
        File file = new File(b.aMZ());
        if (com.baidu.swan.c.d.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
