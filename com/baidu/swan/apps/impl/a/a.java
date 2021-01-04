package com.baidu.swan.apps.impl.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.swan.apps.adaptation.a.w;
import com.baidu.swan.c.d;
import com.baidu.swan.games.i.n;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.impl.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0445a {
        private static final a dfC = new a();
    }

    public static a azm() {
        return C0445a.dfC;
    }

    public void ai(Context context, String str) {
        oU("cloneSwanApp: start");
        d(aa(context, str), str);
        oU("cloneSwanApp: end");
    }

    public File aa(Context context, String str) {
        File file = null;
        if (TextUtils.isEmpty(str)) {
            oU("appKey is empty");
        } else {
            oU("cloneFilesAndMakeZip start, appKey = " + str);
            File file2 = new File(com.baidu.swan.apps.impl.a.a.a.dfK + str);
            if (!y(file2)) {
                oU("delete old tmp dir failed");
            } else {
                File azq = com.baidu.swan.apps.impl.a.a.a.azq();
                if (azq == null) {
                    oU("dest zip dir is null");
                } else {
                    file = new File(azq, com.baidu.swan.apps.impl.a.a.a.dfQ);
                    if (file.exists()) {
                        d.safeDeleteFile(file);
                    }
                    d.createNewFileSafely(file);
                    e(context, str, file2);
                    i(file2.getParentFile(), file);
                    oU("cloneFilesAndMakeZip end, appKey = " + str);
                }
            }
        }
        return file;
    }

    public boolean e(String str, File file) {
        File a2 = a(str, file, com.baidu.swan.apps.impl.a.a.a.dfL);
        if (a2 == null) {
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.dfF, str);
        if (file2.exists()) {
            File file3 = new File(a2, str);
            d.ensureDirectoryExist(file3);
            d.l(file2, file3);
            return true;
        }
        return false;
    }

    public boolean f(String str, File file) {
        File a2 = a(str, file, com.baidu.swan.apps.impl.a.a.a.dfM);
        if (a2 == null) {
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.dfF, str);
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

    public boolean d(Context context, String str, File file) {
        File a2 = a(str, file, com.baidu.swan.apps.impl.a.a.a.dfO);
        if (context == null || a2 == null) {
            return false;
        }
        return a(context, str, a2, new File(AppRuntime.getAppContext().getFilesDir(), "swan_prefs"), ".kv") | a(context, str, a2, new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"), ".xml");
    }

    public boolean g(String str, File file) {
        File a2 = a(str, file, com.baidu.swan.apps.impl.a.a.a.dfP);
        if (a2 == null) {
            return false;
        }
        i("ai_apps.db", a2);
        i("ai_apps_pms.db", a2);
        return true;
    }

    public boolean oT(String str) {
        return true;
    }

    public boolean h(String str, File file) {
        File a2 = a(str, new File(file, com.baidu.swan.apps.impl.a.a.a.dfN), "swan_plugin_workspace");
        if (a2 != null) {
            File aAj = com.baidu.swan.apps.r.d.aAj();
            if (aAj.exists()) {
                d.l(aAj, a2);
            }
        }
        return false;
    }

    public boolean d(final File file, String str) {
        String[] list;
        if (file == null || !file.exists()) {
            oU("no zip file");
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.dfF, str);
        String str2 = "-1";
        if (file2.exists() && (list = file2.list()) != null && list.length > 0) {
            str2 = list[0];
        }
        oU("upload file: ready");
        w aAA = com.baidu.swan.apps.t.a.aAA();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("aiappid", str);
        hashMap.put("aiappversion", str2);
        aAA.a(hashMap, file, new w.a() { // from class: com.baidu.swan.apps.impl.a.a.1
            @Override // com.baidu.swan.apps.adaptation.a.w.a
            public void onResult(String str3) {
                if (!com.baidu.swan.apps.b.DEBUG) {
                    d.safeDeleteFile(file);
                }
                a.this.oU("upload file: done. feedback data = " + str3);
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

    public boolean y(File file) {
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

    public void oU(String str) {
        if (!TextUtils.isEmpty(str) && DEBUG) {
            Log.d("SwanAppCloneModule", str);
        }
    }

    private void i(String str, File file) {
        if (!TextUtils.isEmpty(str) && file != null && file.exists()) {
            File databasePath = AppRuntime.getApplication().getDatabasePath(str);
            if (databasePath.exists()) {
                d.copyFile(databasePath, new File(file, str));
            }
        }
    }

    private void e(Context context, String str, File file) {
        boolean e = e(str, file);
        boolean f = f(com.baidu.swan.apps.impl.a.a.a.dfG, file);
        boolean f2 = f(com.baidu.swan.apps.impl.a.a.a.dfH, file);
        boolean d = d(context, str, file);
        boolean g = g(str, file);
        boolean oT = oT(str);
        oU("cloneSwanPkg = " + e + " ; cloneSwanCore = " + f + " ; cloneExtensionCore = " + f2 + " ; cloneSp = " + d + " ; cloneDb = " + g + " ; cloneAbTest = " + oT + " ; cloneDynamicLib = " + h(str, file));
    }

    private void i(File file, File file2) {
        boolean dh = n.dh(file.getAbsolutePath(), file2.getAbsolutePath());
        if (dh) {
            d.deleteFile(file);
        }
        oU("zip file status = " + dh);
    }
}
