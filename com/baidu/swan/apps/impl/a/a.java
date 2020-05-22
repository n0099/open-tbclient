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
    public static class C0352a {
        private static final a ceT = new a();
    }

    public static a aef() {
        return C0352a.ceT;
    }

    public void S(Context context, String str) {
        kt("cloneSwanApp: start");
        c(K(context, str), str);
        kt("cloneSwanApp: end");
    }

    public File K(Context context, String str) {
        File file = null;
        if (TextUtils.isEmpty(str)) {
            kt("appKey is empty");
        } else {
            kt("cloneFilesAndMakeZip start, appKey = " + str);
            File file2 = new File(com.baidu.swan.apps.impl.a.a.a.cfa + str);
            if (!s(file2)) {
                kt("delete old tmp dir failed");
            } else {
                File aej = com.baidu.swan.apps.impl.a.a.a.aej();
                if (aej == null) {
                    kt("dest zip dir is null");
                } else {
                    file = new File(aej, com.baidu.swan.apps.impl.a.a.a.cff);
                    if (file.exists()) {
                        d.safeDeleteFile(file);
                    }
                    d.createNewFileSafely(file);
                    b(context, str, file2);
                    g(file2.getParentFile(), file);
                    kt("cloneFilesAndMakeZip end, appKey = " + str);
                }
            }
        }
        return file;
    }

    public boolean c(String str, File file) {
        File a = a(str, file, com.baidu.swan.apps.impl.a.a.a.cfb);
        if (a == null) {
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.ceV, str);
        if (file2.exists()) {
            File file3 = new File(a, str);
            d.ensureDirectoryExist(file3);
            d.j(file2, file3);
            return true;
        }
        return false;
    }

    public boolean d(String str, File file) {
        File a = a(str, file, com.baidu.swan.apps.impl.a.a.a.cfc);
        if (a == null) {
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.ceV, str);
        if (file2.exists()) {
            File file3 = new File(a, str);
            d.ensureDirectoryExist(file3);
            d.j(file2, file3);
            return true;
        }
        return false;
    }

    public boolean a(Context context, String str, File file) {
        File a = a(str, file, com.baidu.swan.apps.impl.a.a.a.cfd);
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
        File a = a(str, file, com.baidu.swan.apps.impl.a.a.a.cfe);
        if (a == null) {
            return false;
        }
        f("ai_apps.db", a);
        f("ai_apps_pms.db", a);
        return true;
    }

    public boolean ks(String str) {
        return true;
    }

    public boolean c(final File file, String str) {
        String[] list;
        if (file == null || !file.exists()) {
            kt("no zip file");
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.ceV, str);
        String str2 = "-1";
        if (file2.exists() && (list = file2.list()) != null && list.length > 0) {
            str2 = list[0];
        }
        kt("upload file: ready");
        u afa = com.baidu.swan.apps.u.a.afa();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("aiappid", str);
        hashMap.put("aiappversion", str2);
        afa.a(hashMap, file, new u.a() { // from class: com.baidu.swan.apps.impl.a.a.1
            @Override // com.baidu.swan.apps.adaptation.a.u.a
            public void onResult(String str3) {
                if (!com.baidu.swan.apps.b.DEBUG) {
                    d.safeDeleteFile(file);
                }
                a.this.kt("upload file: done. feedback data = " + str3);
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

    public void kt(String str) {
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
        boolean d = d(com.baidu.swan.apps.impl.a.a.a.ceW, file);
        boolean d2 = d(com.baidu.swan.apps.impl.a.a.a.ceX, file);
        boolean a = a(context, str, file);
        boolean e = e(str, file);
        kt("cloneSwanPkg = " + c + " ; cloneSwanCore = " + d + " ; cloneExtensionCore = " + d2 + " ; cloneSp = " + a + " ; cloneDb = " + e + " ; cloneAbTest = " + ks(str));
    }

    private void g(File file, File file2) {
        boolean cr = n.cr(file.getAbsolutePath(), file2.getAbsolutePath());
        if (cr) {
            d.deleteFile(file);
        }
        kt("zip file status = " + cr);
    }
}
