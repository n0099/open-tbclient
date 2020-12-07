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
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.impl.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0453a {
        private static final a daH = new a();
    }

    public static a axV() {
        return C0453a.daH;
    }

    public void ac(Context context, String str) {
        pb("cloneSwanApp: start");
        c(U(context, str), str);
        pb("cloneSwanApp: end");
    }

    public File U(Context context, String str) {
        File file = null;
        if (TextUtils.isEmpty(str)) {
            pb("appKey is empty");
        } else {
            pb("cloneFilesAndMakeZip start, appKey = " + str);
            File file2 = new File(com.baidu.swan.apps.impl.a.a.a.daP + str);
            if (!v(file2)) {
                pb("delete old tmp dir failed");
            } else {
                File axZ = com.baidu.swan.apps.impl.a.a.a.axZ();
                if (axZ == null) {
                    pb("dest zip dir is null");
                } else {
                    file = new File(axZ, com.baidu.swan.apps.impl.a.a.a.daV);
                    if (file.exists()) {
                        d.safeDeleteFile(file);
                    }
                    d.createNewFileSafely(file);
                    b(context, str, file2);
                    i(file2.getParentFile(), file);
                    pb("cloneFilesAndMakeZip end, appKey = " + str);
                }
            }
        }
        return file;
    }

    public boolean b(String str, File file) {
        File a2 = a(str, file, com.baidu.swan.apps.impl.a.a.a.daQ);
        if (a2 == null) {
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.daK, str);
        if (file2.exists()) {
            File file3 = new File(a2, str);
            d.ensureDirectoryExist(file3);
            d.l(file2, file3);
            return true;
        }
        return false;
    }

    public boolean c(String str, File file) {
        File a2 = a(str, file, com.baidu.swan.apps.impl.a.a.a.daR);
        if (a2 == null) {
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.daK, str);
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
        File a2 = a(str, file, com.baidu.swan.apps.impl.a.a.a.daT);
        if (context == null || a2 == null) {
            return false;
        }
        return a(context, str, a2, new File(AppRuntime.getAppContext().getFilesDir(), "swan_prefs"), ".kv") | a(context, str, a2, new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"), ".xml");
    }

    public boolean d(String str, File file) {
        File a2 = a(str, file, com.baidu.swan.apps.impl.a.a.a.daU);
        if (a2 == null) {
            return false;
        }
        f("ai_apps.db", a2);
        f("ai_apps_pms.db", a2);
        return true;
    }

    public boolean pa(String str) {
        return true;
    }

    public boolean e(String str, File file) {
        File a2 = a(str, new File(file, com.baidu.swan.apps.impl.a.a.a.daS), "swan_plugin_workspace");
        if (a2 != null) {
            File ayS = com.baidu.swan.apps.r.d.ayS();
            if (ayS.exists()) {
                d.l(ayS, a2);
            }
        }
        return false;
    }

    public boolean c(final File file, String str) {
        String[] list;
        if (file == null || !file.exists()) {
            pb("no zip file");
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.daK, str);
        String str2 = "-1";
        if (file2.exists() && (list = file2.list()) != null && list.length > 0) {
            str2 = list[0];
        }
        pb("upload file: ready");
        w azj = com.baidu.swan.apps.t.a.azj();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("aiappid", str);
        hashMap.put("aiappversion", str2);
        azj.a(hashMap, file, new w.a() { // from class: com.baidu.swan.apps.impl.a.a.1
            @Override // com.baidu.swan.apps.adaptation.a.w.a
            public void onResult(String str3) {
                if (!com.baidu.swan.apps.b.DEBUG) {
                    d.safeDeleteFile(file);
                }
                a.this.pb("upload file: done. feedback data = " + str3);
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

    public boolean v(File file) {
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

    public void pb(String str) {
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
        boolean c = c(com.baidu.swan.apps.impl.a.a.a.daL, file);
        boolean c2 = c(com.baidu.swan.apps.impl.a.a.a.daM, file);
        boolean a2 = a(context, str, file);
        boolean d = d(str, file);
        boolean pa = pa(str);
        pb("cloneSwanPkg = " + b + " ; cloneSwanCore = " + c + " ; cloneExtensionCore = " + c2 + " ; cloneSp = " + a2 + " ; cloneDb = " + d + " ; cloneAbTest = " + pa + " ; cloneDynamicLib = " + e(str, file));
    }

    private void i(File file, File file2) {
        boolean di = n.di(file.getAbsolutePath(), file2.getAbsolutePath());
        if (di) {
            d.deleteFile(file);
        }
        pb("zip file status = " + di);
    }
}
