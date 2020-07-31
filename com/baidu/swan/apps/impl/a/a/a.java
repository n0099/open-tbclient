package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.storage.b;
import java.io.File;
/* loaded from: classes7.dex */
public class a {
    public static File clK = d.agZ();
    public static String clL = "swan_core";
    public static String clM = "extension_core";
    public static String clN = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String clO = "cloneFolder_";
    public static String clP = clN + File.separator + clO;
    public static String clQ = "clone_pkg_folder";
    public static String clR = "clone_core_folder";
    public static String clS = "clone_dynamic_lib_folder";
    public static String clT = "clone_sp_folder";
    public static String clU = "clone_db_folder";
    public static String clV = "cloneZip.zip";
    public static String clW = "clone_zipFiles";

    public static File agA() {
        File file = new File(b.auE());
        if (com.baidu.swan.d.d.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
