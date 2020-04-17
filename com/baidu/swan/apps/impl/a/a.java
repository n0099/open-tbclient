package com.baidu.swan.apps.impl.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.swan.apps.adaptation.a.s;
import com.baidu.swan.d.c;
import com.baidu.swan.games.h.l;
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
    public static class C0291a {
        private static final a bUx = new a();
    }

    public static a abf() {
        return C0291a.bUx;
    }

    public void ae(Context context, String str) {
        jl("cloneSwanApp: start");
        c(V(context, str), str);
        jl("cloneSwanApp: end");
    }

    public File V(Context context, String str) {
        File file = null;
        if (TextUtils.isEmpty(str)) {
            jl("appkey is empty");
        } else {
            jl("cloneFilesAndMakeZip start, appKey = " + str);
            File file2 = new File(com.baidu.swan.apps.impl.a.a.a.bUE + str);
            if (!o(file2)) {
                jl("delete old tmp dir failed");
            } else {
                File abj = com.baidu.swan.apps.impl.a.a.a.abj();
                if (abj == null) {
                    jl("dest zip dir is null");
                } else {
                    file = new File(abj, com.baidu.swan.apps.impl.a.a.a.bUJ);
                    if (file.exists()) {
                        c.safeDeleteFile(file);
                    }
                    c.createNewFileSafely(file);
                    b(context, str, file2);
                    g(file2.getParentFile(), file);
                    jl("cloneFilesAndMakeZip end, appKey = " + str);
                }
            }
        }
        return file;
    }

    public boolean c(String str, File file) {
        File a = a(str, file, com.baidu.swan.apps.impl.a.a.a.bUF);
        if (a == null) {
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.bUz, str);
        if (file2.exists()) {
            File file3 = new File(a, str);
            c.ensureDirectoryExist(file3);
            c.j(file2, file3);
            return true;
        }
        return false;
    }

    public boolean d(String str, File file) {
        File a = a(str, file, com.baidu.swan.apps.impl.a.a.a.bUG);
        if (a == null) {
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.bUz, str);
        if (file2.exists()) {
            File file3 = new File(a, str);
            c.ensureDirectoryExist(file3);
            c.j(file2, file3);
            return true;
        }
        return false;
    }

    public boolean a(Context context, String str, File file) {
        File a = a(str, file, com.baidu.swan.apps.impl.a.a.a.bUH);
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
        File a = a(str, file, com.baidu.swan.apps.impl.a.a.a.bUI);
        if (a == null) {
            return false;
        }
        f("ai_apps.db", a);
        f("ai_apps_pms.db", a);
        return true;
    }

    public boolean jk(String str) {
        return true;
    }

    public boolean c(final File file, String str) {
        String[] list;
        if (file == null || !file.exists()) {
            jl("no zip file");
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.bUz, str);
        String str2 = "-1";
        if (file2.exists() && (list = file2.list()) != null && list.length > 0) {
            str2 = list[0];
        }
        jl("upload file: ready");
        s abX = com.baidu.swan.apps.w.a.abX();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("aiappid", str);
        hashMap.put("aiappversion", str2);
        abX.a(hashMap, file, new s.a() { // from class: com.baidu.swan.apps.impl.a.a.1
            @Override // com.baidu.swan.apps.adaptation.a.s.a
            public void onResult(String str3) {
                if (!com.baidu.swan.apps.b.DEBUG) {
                    c.safeDeleteFile(file);
                }
                a.this.jl("upload file: done. feedback data = " + str3);
            }
        });
        return true;
    }

    public File a(String str, File file, String str2) {
        if (TextUtils.isEmpty(str) || file == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file2 = new File(file, str2);
        if (c.ensureDirectoryExist(file2)) {
            return file2;
        }
        return null;
    }

    public boolean o(File file) {
        if (file == null) {
            return false;
        }
        c.deleteFile(file);
        return c.ensureDirectoryExist(file);
    }

    private void a(String str, File file, File file2) {
        if (!TextUtils.isEmpty(str) && file != null && file.exists() && file2 != null && file2.exists()) {
            String str2 = str + ".xml";
            File file3 = new File(file, str2);
            if (file3.exists()) {
                c.copyFile(file3, new File(file2, str2));
            }
        }
    }

    public void jl(String str) {
        if (!TextUtils.isEmpty(str) && DEBUG) {
            Log.d("SwanAppCloneModule", str);
        }
    }

    private void f(String str, File file) {
        if (!TextUtils.isEmpty(str) && file != null && file.exists()) {
            File databasePath = AppRuntime.getApplication().getDatabasePath(str);
            if (databasePath.exists()) {
                c.copyFile(databasePath, new File(file, str));
            }
        }
    }

    private void b(Context context, String str, File file) {
        boolean c = c(str, file);
        boolean d = d(com.baidu.swan.apps.impl.a.a.a.bUA, file);
        boolean d2 = d(com.baidu.swan.apps.impl.a.a.a.bUB, file);
        boolean a = a(context, str, file);
        boolean e = e(str, file);
        jl("cloneSwanPkg = " + c + " ; cloneSwanCore = " + d + " ; cloneExtensionCore = " + d2 + " ; cloneSp = " + a + " ; cloneDb = " + e + " ; cloneAbTest = " + jk(str));
    }

    private void g(File file, File file2) {
        boolean bW = l.bW(file.getAbsolutePath(), file2.getAbsolutePath());
        if (bW) {
            c.deleteFile(file);
        }
        jl("zip file status = " + bW);
    }
}
