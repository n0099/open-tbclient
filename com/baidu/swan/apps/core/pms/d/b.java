package com.baidu.swan.apps.core.pms.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.t.a.a;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.games.k.a;
import com.baidu.swan.pms.model.g;
import java.io.File;
import java.util.List;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static String iw(String str) {
        return aM(str, "swan_sub_package_zip");
    }

    public static String aK(String str, String str2) {
        return iw(e.d.aT(str, str2).getPath());
    }

    public static String ix(String str) {
        return aM(str, "swan_sub_package_zip");
    }

    public static String aL(String str, String str2) {
        return ix(a.c.aT(str, str2).getPath());
    }

    private static String aM(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            return file.getPath();
        }
        if (file.mkdirs()) {
            return file.getPath();
        }
        return null;
    }

    public static boolean i(g gVar) {
        if (gVar == null || TextUtils.isEmpty(gVar.appId)) {
            return false;
        }
        return f(new File(gVar.filePath), new File(e.d.aT(gVar.appId, String.valueOf(gVar.versionCode)).getPath(), gVar.pkgName));
    }

    public static boolean f(File file, File file2) {
        boolean unzipFile;
        if (file == null || file2 == null) {
            return false;
        }
        if (!file.exists()) {
            if (DEBUG) {
                Log.e("SubPkgDownloadUtil", "解压分包时，ZIP包不存在");
                return false;
            }
            return false;
        } else if (!file2.exists() && !file2.mkdirs()) {
            if (DEBUG) {
                Log.e("SubPkgDownloadUtil", "创建分包解压文件夹失败");
                return false;
            }
            return false;
        } else {
            a.b s = com.baidu.swan.apps.t.a.a.s(file);
            if (s.type != -1) {
                unzipFile = com.baidu.swan.apps.t.a.a.a(s.bWc, file2, s.type).isSuccess;
            } else {
                unzipFile = com.baidu.swan.d.c.unzipFile(file.getAbsolutePath(), file2.getAbsolutePath());
            }
            if (unzipFile) {
                if (DEBUG) {
                    Log.e("SubPkgDownloadUtil", "分包解压成功");
                }
                return true;
            } else if (DEBUG) {
                Log.e("SubPkgDownloadUtil", "分包解压文件失败, file:" + file.getAbsolutePath() + " folder:" + file2.getAbsolutePath());
                return false;
            } else {
                return false;
            }
        }
    }

    public static boolean T(List<g> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        return list.get(0).independent;
    }
}
