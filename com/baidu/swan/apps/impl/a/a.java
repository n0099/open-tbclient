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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.impl.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0405a {
        private static final a csP = new a();
    }

    public static a anE() {
        return C0405a.csP;
    }

    public void V(Context context, String str) {
        mL("cloneSwanApp: start");
        c(N(context, str), str);
        mL("cloneSwanApp: end");
    }

    public File N(Context context, String str) {
        File file = null;
        if (TextUtils.isEmpty(str)) {
            mL("appKey is empty");
        } else {
            mL("cloneFilesAndMakeZip start, appKey = " + str);
            File file2 = new File(com.baidu.swan.apps.impl.a.a.a.csX + str);
            if (!t(file2)) {
                mL("delete old tmp dir failed");
            } else {
                File anI = com.baidu.swan.apps.impl.a.a.a.anI();
                if (anI == null) {
                    mL("dest zip dir is null");
                } else {
                    file = new File(anI, com.baidu.swan.apps.impl.a.a.a.ctd);
                    if (file.exists()) {
                        d.safeDeleteFile(file);
                    }
                    d.createNewFileSafely(file);
                    b(context, str, file2);
                    h(file2.getParentFile(), file);
                    mL("cloneFilesAndMakeZip end, appKey = " + str);
                }
            }
        }
        return file;
    }

    public boolean c(String str, File file) {
        File a = a(str, file, com.baidu.swan.apps.impl.a.a.a.csY);
        if (a == null) {
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.csS, str);
        if (file2.exists()) {
            File file3 = new File(a, str);
            d.ensureDirectoryExist(file3);
            d.k(file2, file3);
            return true;
        }
        return false;
    }

    public boolean d(String str, File file) {
        File a = a(str, file, com.baidu.swan.apps.impl.a.a.a.csZ);
        if (a == null) {
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.csS, str);
        if (file2.exists()) {
            File file3 = new File(a, str);
            d.ensureDirectoryExist(file3);
            d.k(file2, file3);
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
        File a = a(str, file, com.baidu.swan.apps.impl.a.a.a.ctb);
        if (context == null || a == null) {
            return false;
        }
        return a(context, str, a, new File(AppRuntime.getAppContext().getFilesDir(), "swan_prefs"), ".kv") | a(context, str, a, new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"), ".xml");
    }

    public boolean e(String str, File file) {
        File a = a(str, file, com.baidu.swan.apps.impl.a.a.a.ctc);
        if (a == null) {
            return false;
        }
        g("ai_apps.db", a);
        g("ai_apps_pms.db", a);
        return true;
    }

    public boolean mK(String str) {
        return true;
    }

    public boolean f(String str, File file) {
        File a = a(str, new File(file, com.baidu.swan.apps.impl.a.a.a.cta), "swan_plugin_workspace");
        if (a != null) {
            File aoB = com.baidu.swan.apps.r.d.aoB();
            if (aoB.exists()) {
                d.k(aoB, a);
            }
        }
        return false;
    }

    public boolean c(final File file, String str) {
        String[] list;
        if (file == null || !file.exists()) {
            mL("no zip file");
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.csS, str);
        String str2 = "-1";
        if (file2.exists() && (list = file2.list()) != null && list.length > 0) {
            str2 = list[0];
        }
        mL("upload file: ready");
        w aoS = com.baidu.swan.apps.t.a.aoS();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("aiappid", str);
        hashMap.put("aiappversion", str2);
        aoS.a(hashMap, file, new w.a() { // from class: com.baidu.swan.apps.impl.a.a.1
            @Override // com.baidu.swan.apps.adaptation.a.w.a
            public void onResult(String str3) {
                if (!com.baidu.swan.apps.b.DEBUG) {
                    d.safeDeleteFile(file);
                }
                a.this.mL("upload file: done. feedback data = " + str3);
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

    public boolean t(File file) {
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

    public void mL(String str) {
        if (!TextUtils.isEmpty(str) && DEBUG) {
            Log.d("SwanAppCloneModule", str);
        }
    }

    private void g(String str, File file) {
        if (!TextUtils.isEmpty(str) && file != null && file.exists()) {
            File databasePath = AppRuntime.getApplication().getDatabasePath(str);
            if (databasePath.exists()) {
                d.copyFile(databasePath, new File(file, str));
            }
        }
    }

    private void b(Context context, String str, File file) {
        boolean c = c(str, file);
        boolean d = d(com.baidu.swan.apps.impl.a.a.a.csT, file);
        boolean d2 = d(com.baidu.swan.apps.impl.a.a.a.csU, file);
        boolean a = a(context, str, file);
        boolean e = e(str, file);
        boolean mK = mK(str);
        mL("cloneSwanPkg = " + c + " ; cloneSwanCore = " + d + " ; cloneExtensionCore = " + d2 + " ; cloneSp = " + a + " ; cloneDb = " + e + " ; cloneAbTest = " + mK + " ; cloneDynamicLib = " + f(str, file));
    }

    private void h(File file, File file2) {
        boolean cQ = n.cQ(file.getAbsolutePath(), file2.getAbsolutePath());
        if (cQ) {
            d.deleteFile(file);
        }
        mL("zip file status = " + cQ);
    }
}
