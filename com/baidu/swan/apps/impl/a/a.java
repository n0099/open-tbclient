package com.baidu.swan.apps.impl.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.swan.apps.adaptation.a.w;
import com.baidu.swan.c.d;
import com.baidu.swan.games.i.n;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.impl.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0443a {
        private static final a cVv = new a();
    }

    public static a avv() {
        return C0443a.cVv;
    }

    public void ac(Context context, String str) {
        oA("cloneSwanApp: start");
        c(U(context, str), str);
        oA("cloneSwanApp: end");
    }

    public File U(Context context, String str) {
        File file = null;
        if (TextUtils.isEmpty(str)) {
            oA("appKey is empty");
        } else {
            oA("cloneFilesAndMakeZip start, appKey = " + str);
            File file2 = new File(com.baidu.swan.apps.impl.a.a.a.cVD + str);
            if (!w(file2)) {
                oA("delete old tmp dir failed");
            } else {
                File avz = com.baidu.swan.apps.impl.a.a.a.avz();
                if (avz == null) {
                    oA("dest zip dir is null");
                } else {
                    file = new File(avz, com.baidu.swan.apps.impl.a.a.a.cVJ);
                    if (file.exists()) {
                        d.safeDeleteFile(file);
                    }
                    d.createNewFileSafely(file);
                    b(context, str, file2);
                    i(file2.getParentFile(), file);
                    oA("cloneFilesAndMakeZip end, appKey = " + str);
                }
            }
        }
        return file;
    }

    public boolean b(String str, File file) {
        File a2 = a(str, file, com.baidu.swan.apps.impl.a.a.a.cVE);
        if (a2 == null) {
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.cVy, str);
        if (file2.exists()) {
            File file3 = new File(a2, str);
            d.ensureDirectoryExist(file3);
            d.l(file2, file3);
            return true;
        }
        return false;
    }

    public boolean c(String str, File file) {
        File a2 = a(str, file, com.baidu.swan.apps.impl.a.a.a.cVF);
        if (a2 == null) {
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.cVy, str);
        if (file2.exists()) {
            File file3 = new File(a2, str);
            d.ensureDirectoryExist(file3);
            d.l(file2, file3);
            return true;
        }
        return false;
    }

    private boolean a(@NonNull Context context, @NonNull String str, @NonNull File file, @Nullable File file2, @NonNull String str2) {
        if (file2 != null && file2.exists() && file2.isDirectory()) {
            for (String str3 : new String[]{"aiapp_" + str, "aiapp_setting_" + str, "searchbox_webapps_sp", "searchbox_sconsole_sp", "aiapp_open_stat", QuickPersistConfig.SP_FILE_STARTUP, "com.baidu.searchbox_aiapp_openstat", "aiapps_favorite", "aiapps_guide_dialog_sp", "key_pms_sp_name", context.getPackageName() + "_preferences", "abtesting"}) {
                a(str3, file2, file, str2);
            }
            return true;
        }
        return false;
    }

    public boolean a(Context context, String str, File file) {
        File a2 = a(str, file, com.baidu.swan.apps.impl.a.a.a.cVH);
        if (context == null || a2 == null) {
            return false;
        }
        return a(context, str, a2, new File(AppRuntime.getAppContext().getFilesDir(), "swan_prefs"), ".kv") | a(context, str, a2, new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"), ".xml");
    }

    public boolean d(String str, File file) {
        File a2 = a(str, file, com.baidu.swan.apps.impl.a.a.a.cVI);
        if (a2 == null) {
            return false;
        }
        f("ai_apps.db", a2);
        f("ai_apps_pms.db", a2);
        return true;
    }

    public boolean oz(String str) {
        return true;
    }

    public boolean e(String str, File file) {
        File a2 = a(str, new File(file, com.baidu.swan.apps.impl.a.a.a.cVG), "swan_plugin_workspace");
        if (a2 != null) {
            File aws = com.baidu.swan.apps.r.d.aws();
            if (aws.exists()) {
                d.l(aws, a2);
            }
        }
        return false;
    }

    public boolean c(final File file, String str) {
        String[] list;
        if (file == null || !file.exists()) {
            oA("no zip file");
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.cVy, str);
        String str2 = "-1";
        if (file2.exists() && (list = file2.list()) != null && list.length > 0) {
            str2 = list[0];
        }
        oA("upload file: ready");
        w awJ = com.baidu.swan.apps.t.a.awJ();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("aiappid", str);
        hashMap.put("aiappversion", str2);
        awJ.a(hashMap, file, new w.a() { // from class: com.baidu.swan.apps.impl.a.a.1
            @Override // com.baidu.swan.apps.adaptation.a.w.a
            public void onResult(String str3) {
                if (!com.baidu.swan.apps.b.DEBUG) {
                    d.safeDeleteFile(file);
                }
                a.this.oA("upload file: done. feedback data = " + str3);
            }
        });
        return true;
    }

    public File a(String str, File file, String str2) {
        if (TextUtils.isEmpty(str) || file == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file2 = new File(file, str2);
        if (d.ensureDirectoryExist(file2)) {
            return file2;
        }
        return null;
    }

    public boolean w(File file) {
        if (file == null) {
            return false;
        }
        d.deleteFile(file);
        return d.ensureDirectoryExist(file);
    }

    private void a(String str, File file, File file2, String str2) {
        if (!TextUtils.isEmpty(str) && file != null && file.exists() && file2 != null && file2.exists()) {
            String str3 = str + str2;
            File file3 = new File(file, str3);
            if (file3.exists()) {
                d.copyFile(file3, new File(file2, str3));
            }
        }
    }

    public void oA(String str) {
        if (!TextUtils.isEmpty(str) && DEBUG) {
            Log.d("SwanAppCloneModule", str);
        }
    }

    private void f(String str, File file) {
        if (!TextUtils.isEmpty(str) && file != null && file.exists()) {
            File databasePath = AppRuntime.getApplication().getDatabasePath(str);
            if (databasePath.exists()) {
                d.copyFile(databasePath, new File(file, str));
            }
        }
    }

    private void b(Context context, String str, File file) {
        boolean b = b(str, file);
        boolean c = c(com.baidu.swan.apps.impl.a.a.a.cVz, file);
        boolean c2 = c(com.baidu.swan.apps.impl.a.a.a.cVA, file);
        boolean a2 = a(context, str, file);
        boolean d = d(str, file);
        boolean oz = oz(str);
        oA("cloneSwanPkg = " + b + " ; cloneSwanCore = " + c + " ; cloneExtensionCore = " + c2 + " ; cloneSp = " + a2 + " ; cloneDb = " + d + " ; cloneAbTest = " + oz + " ; cloneDynamicLib = " + e(str, file));
    }

    private void i(File file, File file2) {
        boolean dc = n.dc(file.getAbsolutePath(), file2.getAbsolutePath());
        if (dc) {
            d.deleteFile(file);
        }
        oA("zip file status = " + dc);
    }
}
