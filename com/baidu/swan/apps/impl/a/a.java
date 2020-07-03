package com.baidu.swan.apps.impl.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.swan.apps.adaptation.a.u;
import com.baidu.swan.e.d;
import com.baidu.swan.games.i.n;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.impl.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0358a {
        private static final a cjH = new a();
    }

    public static a afl() {
        return C0358a.cjH;
    }

    public void S(Context context, String str) {
        kB("cloneSwanApp: start");
        c(K(context, str), str);
        kB("cloneSwanApp: end");
    }

    public File K(Context context, String str) {
        File file = null;
        if (TextUtils.isEmpty(str)) {
            kB("appKey is empty");
        } else {
            kB("cloneFilesAndMakeZip start, appKey = " + str);
            File file2 = new File(com.baidu.swan.apps.impl.a.a.a.cjO + str);
            if (!s(file2)) {
                kB("delete old tmp dir failed");
            } else {
                File afp = com.baidu.swan.apps.impl.a.a.a.afp();
                if (afp == null) {
                    kB("dest zip dir is null");
                } else {
                    file = new File(afp, com.baidu.swan.apps.impl.a.a.a.cjT);
                    if (file.exists()) {
                        d.safeDeleteFile(file);
                    }
                    d.createNewFileSafely(file);
                    b(context, str, file2);
                    g(file2.getParentFile(), file);
                    kB("cloneFilesAndMakeZip end, appKey = " + str);
                }
            }
        }
        return file;
    }

    public boolean c(String str, File file) {
        File a = a(str, file, com.baidu.swan.apps.impl.a.a.a.cjP);
        if (a == null) {
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.cjJ, str);
        if (file2.exists()) {
            File file3 = new File(a, str);
            d.ensureDirectoryExist(file3);
            d.j(file2, file3);
            return true;
        }
        return false;
    }

    public boolean d(String str, File file) {
        File a = a(str, file, com.baidu.swan.apps.impl.a.a.a.cjQ);
        if (a == null) {
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.cjJ, str);
        if (file2.exists()) {
            File file3 = new File(a, str);
            d.ensureDirectoryExist(file3);
            d.j(file2, file3);
            return true;
        }
        return false;
    }

    public boolean a(Context context, String str, File file) {
        File a = a(str, file, com.baidu.swan.apps.impl.a.a.a.cjR);
        if (a == null) {
            return false;
        }
        File file2 = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/");
        if (file2.exists() && file2.isDirectory()) {
            a("aiapp_" + str, file2, a);
            a("aiapp_setting_" + str, file2, a);
            a("searchbox_webapps_sp", file2, a);
            a("searchbox_sconsole_sp", file2, a);
            a("aiapp_open_stat", file2, a);
            a(QuickPersistConfig.SP_FILE_STARTUP, file2, a);
            a("com.baidu.searchbox_aiapp_openstat", file2, a);
            a("aiapps_favorite", file2, a);
            a("aiapps_guide_dialog_sp", file2, a);
            a("key_pms_sp_name", file2, a);
            if (context != null) {
                a(context.getPackageName() + "_preferences", file2, a);
            }
            a("abtesting", file2, a);
            return true;
        }
        return false;
    }

    public boolean e(String str, File file) {
        File a = a(str, file, com.baidu.swan.apps.impl.a.a.a.cjS);
        if (a == null) {
            return false;
        }
        f("ai_apps.db", a);
        f("ai_apps_pms.db", a);
        return true;
    }

    public boolean kA(String str) {
        return true;
    }

    public boolean c(final File file, String str) {
        String[] list;
        if (file == null || !file.exists()) {
            kB("no zip file");
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.cjJ, str);
        String str2 = "-1";
        if (file2.exists() && (list = file2.list()) != null && list.length > 0) {
            str2 = list[0];
        }
        kB("upload file: ready");
        u agg = com.baidu.swan.apps.u.a.agg();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("aiappid", str);
        hashMap.put("aiappversion", str2);
        agg.a(hashMap, file, new u.a() { // from class: com.baidu.swan.apps.impl.a.a.1
            @Override // com.baidu.swan.apps.adaptation.a.u.a
            public void onResult(String str3) {
                if (!com.baidu.swan.apps.b.DEBUG) {
                    d.safeDeleteFile(file);
                }
                a.this.kB("upload file: done. feedback data = " + str3);
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

    public boolean s(File file) {
        if (file == null) {
            return false;
        }
        d.deleteFile(file);
        return d.ensureDirectoryExist(file);
    }

    private void a(String str, File file, File file2) {
        if (!TextUtils.isEmpty(str) && file != null && file.exists() && file2 != null && file2.exists()) {
            String str2 = str + ".xml";
            File file3 = new File(file, str2);
            if (file3.exists()) {
                d.copyFile(file3, new File(file2, str2));
            }
        }
    }

    public void kB(String str) {
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
        boolean c = c(str, file);
        boolean d = d(com.baidu.swan.apps.impl.a.a.a.cjK, file);
        boolean d2 = d(com.baidu.swan.apps.impl.a.a.a.cjL, file);
        boolean a = a(context, str, file);
        boolean e = e(str, file);
        kB("cloneSwanPkg = " + c + " ; cloneSwanCore = " + d + " ; cloneExtensionCore = " + d2 + " ; cloneSp = " + a + " ; cloneDb = " + e + " ; cloneAbTest = " + kA(str));
    }

    private void g(File file, File file2) {
        boolean ct = n.ct(file.getAbsolutePath(), file2.getAbsolutePath());
        if (ct) {
            d.deleteFile(file);
        }
        kB("zip file status = " + ct);
    }
}
