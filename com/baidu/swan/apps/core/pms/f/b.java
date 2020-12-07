package com.baidu.swan.apps.core.pms.f;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.r.a.a;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.games.l.a;
import com.baidu.swan.pms.model.g;
import java.io.File;
import java.util.List;
/* loaded from: classes25.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static String nU(String str) {
        return bK(str, "swan_sub_package_zip");
    }

    public static String bI(String str, String str2) {
        return nU(d.C0474d.bT(str, str2).getPath());
    }

    public static String nV(String str) {
        return bK(str, "swan_sub_package_zip");
    }

    public static String bJ(String str, String str2) {
        return nV(a.c.bT(str, str2).getPath());
    }

    private static String bK(String str, String str2) {
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
        return h(new File(gVar.filePath), new File(d.C0474d.bT(gVar.appId, String.valueOf(gVar.versionCode)).getPath(), gVar.pkgName));
    }

    public static boolean h(File file, File file2) {
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
            a.b A = com.baidu.swan.apps.r.a.a.A(file);
            if (A.type != -1) {
                unzipFile = com.baidu.swan.apps.r.a.a.a(A.dcK, file2, A.type).isSuccess;
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

    public static boolean aA(List<g> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        return list.get(0).enf;
    }
}
