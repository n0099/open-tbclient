package com.baidu.swan.mini.c;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.t.a.a;
import com.baidu.swan.d.c;
import java.io.File;
import java.io.FileFilter;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Nullable
    public static File b(com.baidu.swan.pms.b.a aVar) {
        if (aVar == null) {
            return null;
        }
        String appId = aVar.getAppId();
        String bundleId = aVar.getBundleId();
        if (TextUtils.isEmpty(appId) || TextUtils.isEmpty(bundleId)) {
            return null;
        }
        return P(appId, bundleId, String.valueOf(aVar.getVersionCode()));
    }

    @NonNull
    public static File P(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "swan_mini_folder" + File.separator + str + File.separator + str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static com.baidu.swan.pms.b.b.b a(com.baidu.swan.pms.b.a aVar, String str) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return new com.baidu.swan.pms.b.b.b(1010, "unZipPkgBundle: pkg or filePath is null ");
        }
        File file = new File(str);
        File b = b(aVar);
        if (!file.exists()) {
            return new com.baidu.swan.pms.b.b.b(1010, "unZipPkgBundle: bundleZipFile 不存在");
        }
        if (b == null) {
            return new com.baidu.swan.pms.b.b.b(1002, "解压失败：解压目录为null");
        }
        if (b.isFile() && !b.delete()) {
            return new com.baidu.swan.pms.b.b.b(1002, "解压失败：解压目录被文件占用，且无法删除");
        }
        if (!b.exists() && !b.mkdirs()) {
            return new com.baidu.swan.pms.b.b.b(1002, "解压失败：解压文件夹创建失败");
        }
        a.b s = com.baidu.swan.apps.t.a.a.s(file);
        if (s.type != -1) {
            if (com.baidu.swan.apps.t.a.a.a(s.bWc, b, s.type).isSuccess) {
                return new com.baidu.swan.pms.b.b.b(0, "解密成功");
            }
            return new com.baidu.swan.pms.b.b.b(1011, "解密失败");
        } else if (c.unzipFile(file.getAbsolutePath(), b.getAbsolutePath())) {
            return new com.baidu.swan.pms.b.b.b(0, "解压成功");
        } else {
            return new com.baidu.swan.pms.b.b.b(1002, "解压失败");
        }
    }

    public static void c(com.baidu.swan.pms.b.a aVar) {
        if (aVar != null) {
            e(aVar.getAppId(), aVar.getBundleId(), aVar.getVersionCode());
        }
    }

    private static void e(String str, String str2, long j) {
        File[] listFiles;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "swan_mini_folder" + File.separator + str, str2).listFiles(new FileFilter() { // from class: com.baidu.swan.mini.c.b.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
            }
        })) != null && listFiles.length > 0) {
            for (File file : listFiles) {
                if (file != null && e(j, file.getName()) && !com.baidu.swan.mini.a.aBs().contains(file.getAbsolutePath())) {
                    if (DEBUG) {
                        Log.i("Mini-Pm", "删除低版本文件夹：" + file.getAbsolutePath());
                    }
                    c.deleteFile(file);
                }
            }
        }
    }

    private static boolean e(long j, String str) {
        if (DEBUG) {
            Log.i("Mini-Pm", "curVersion:" + j + " ,targetVersion:" + str);
        }
        try {
            if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
                return j - Long.parseLong(str) > 0;
            }
            return false;
        } catch (NumberFormatException e) {
            if (DEBUG) {
                Log.e("Mini-Pm", "比较版本号Exception：" + e.getMessage());
                return false;
            }
            return false;
        }
    }
}
