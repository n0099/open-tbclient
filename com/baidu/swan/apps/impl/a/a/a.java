package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.storage.b;
import java.io.File;
/* loaded from: classes10.dex */
public class a {
    public static File cVy = d.awq();
    public static String cVz = "swan_core";
    public static String cVA = "extension_core";
    public static String cVB = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String cVC = "cloneFolder_";
    public static String cVD = cVB + File.separator + cVC;
    public static String cVE = "clone_pkg_folder";
    public static String cVF = "clone_core_folder";
    public static String cVG = "clone_dynamic_lib_folder";
    public static String cVH = "clone_sp_folder";
    public static String cVI = "clone_db_folder";
    public static String cVJ = "cloneZip.zip";
    public static String cVK = "clone_zipFiles";

    public static File avz() {
        File file = new File(b.aKA());
        if (com.baidu.swan.c.d.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
