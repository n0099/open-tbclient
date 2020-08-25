package com.baidu.swan.apps.core.pms.f;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.r.a.a;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.games.l.a;
import com.baidu.swan.pms.model.g;
import java.io.File;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static String lF(String str) {
        return bs(str, "swan_sub_package_zip");
    }

    public static String bq(String str, String str2) {
        return lF(d.C0426d.bB(str, str2).getPath());
    }

    public static String lG(String str) {
        return bs(str, "swan_sub_package_zip");
    }

    public static String br(String str, String str2) {
        return lG(a.c.bB(str, str2).getPath());
    }

    private static String bs(String str, String str2) {
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

    public static boolean j(g gVar) {
        if (gVar == null || TextUtils.isEmpty(gVar.appId)) {
            return false;
        }
        return g(new File(gVar.filePath), new File(d.C0426d.bB(gVar.appId, String.valueOf(gVar.versionCode)).getPath(), gVar.pkgName));
    }

    public static boolean g(File file, File file2) {
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
            a.b y = com.baidu.swan.apps.r.a.a.y(file);
            if (y.type != -1) {
                unzipFile = com.baidu.swan.apps.r.a.a.a(y.cuY, file2, y.type).isSuccess;
            } else {
                unzipFile = com.baidu.swan.c.d.unzipFile(file.getAbsolutePath(), file2.getAbsolutePath());
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

    public static boolean Z(List<g> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        return list.get(0).dFo;
    }
}
