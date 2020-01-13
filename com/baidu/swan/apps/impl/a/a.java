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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.impl.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0251a {
        private static final a brT = new a();
    }

    public static a QX() {
        return C0251a.brT;
    }

    public void ak(Context context, String str) {
        hJ("cloneSwanApp: start");
        b(ab(context, str), str);
        hJ("cloneSwanApp: end");
    }

    public File ab(Context context, String str) {
        File file = null;
        if (TextUtils.isEmpty(str)) {
            hJ("appkey is empty");
        } else {
            hJ("cloneFilesAndMakeZip start, appKey = " + str);
            File file2 = new File(com.baidu.swan.apps.impl.a.a.a.bsa + str);
            if (!m(file2)) {
                hJ("delete old tmp dir failed");
            } else {
                File Rb = com.baidu.swan.apps.impl.a.a.a.Rb();
                if (Rb == null) {
                    hJ("dest zip dir is null");
                } else {
                    file = new File(Rb, com.baidu.swan.apps.impl.a.a.a.bsf);
                    if (file.exists()) {
                        c.safeDeleteFile(file);
                    }
                    c.createNewFileSafely(file);
                    b(context, str, file2);
                    f(file2.getParentFile(), file);
                    hJ("cloneFilesAndMakeZip end, appKey = " + str);
                }
            }
        }
        return file;
    }

    public boolean d(String str, File file) {
        File b = b(str, file, com.baidu.swan.apps.impl.a.a.a.bsb);
        if (b == null) {
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.brV, str);
        if (file2.exists()) {
            File file3 = new File(b, str);
            c.ensureDirectoryExist(file3);
            c.i(file2, file3);
            return true;
        }
        return false;
    }

    public boolean e(String str, File file) {
        File b = b(str, file, com.baidu.swan.apps.impl.a.a.a.bsc);
        if (b == null) {
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.brV, str);
        if (file2.exists()) {
            File file3 = new File(b, str);
            c.ensureDirectoryExist(file3);
            c.i(file2, file3);
            return true;
        }
        return false;
    }

    public boolean a(Context context, String str, File file) {
        File b = b(str, file, com.baidu.swan.apps.impl.a.a.a.bsd);
        if (b == null) {
            return false;
        }
        File file2 = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/");
        if (file2.exists() && file2.isDirectory()) {
            a("aiapp_" + str, file2, b);
            a("aiapp_setting_" + str, file2, b);
            a("searchbox_webapps_sp", file2, b);
            a("searchbox_sconsole_sp", file2, b);
            a("aiapp_open_stat", file2, b);
            a(QuickPersistConfig.SP_FILE_STARTUP, file2, b);
            a("com.baidu.searchbox_aiapp_openstat", file2, b);
            a("aiapps_favorite", file2, b);
            a("aiapps_guide_dialog_sp", file2, b);
            a("key_pms_sp_name", file2, b);
            if (context != null) {
                a(context.getPackageName() + "_preferences", file2, b);
            }
            a("abtesting", file2, b);
            return true;
        }
        return false;
    }

    public boolean f(String str, File file) {
        File b = b(str, file, com.baidu.swan.apps.impl.a.a.a.bse);
        if (b == null) {
            return false;
        }
        g("ai_apps.db", b);
        g("ai_apps_pms.db", b);
        return true;
    }

    public boolean hI(String str) {
        return true;
    }

    public boolean b(final File file, String str) {
        String[] list;
        if (file == null || !file.exists()) {
            hJ("no zip file");
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.brV, str);
        String str2 = "-1";
        if (file2.exists() && (list = file2.list()) != null && list.length > 0) {
            str2 = list[0];
        }
        hJ("upload file: ready");
        s RP = com.baidu.swan.apps.w.a.RP();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("aiappid", str);
        hashMap.put("aiappversion", str2);
        RP.a(hashMap, file, new s.a() { // from class: com.baidu.swan.apps.impl.a.a.1
            @Override // com.baidu.swan.apps.adaptation.a.s.a
            public void onResult(String str3) {
                if (!com.baidu.swan.apps.b.DEBUG) {
                    c.safeDeleteFile(file);
                }
                a.this.hJ("upload file: done. feedback data = " + str3);
            }
        });
        return true;
    }

    public File b(String str, File file, String str2) {
        if (TextUtils.isEmpty(str) || file == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file2 = new File(file, str2);
        if (c.ensureDirectoryExist(file2)) {
            return file2;
        }
        return null;
    }

    public boolean m(File file) {
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

    public void hJ(String str) {
        if (!TextUtils.isEmpty(str) && DEBUG) {
            Log.d("SwanAppCloneModule", str);
        }
    }

    private void g(String str, File file) {
        if (!TextUtils.isEmpty(str) && file != null && file.exists()) {
            File databasePath = AppRuntime.getApplication().getDatabasePath(str);
            if (databasePath.exists()) {
                c.copyFile(databasePath, new File(file, str));
            }
        }
    }

    private void b(Context context, String str, File file) {
        boolean d = d(str, file);
        boolean e = e(com.baidu.swan.apps.impl.a.a.a.brW, file);
        boolean e2 = e(com.baidu.swan.apps.impl.a.a.a.brX, file);
        boolean a = a(context, str, file);
        boolean f = f(str, file);
        hJ("cloneSwanPkg = " + d + " ; cloneSwanCore = " + e + " ; cloneExtensionCore = " + e2 + " ; cloneSp = " + a + " ; cloneDb = " + f + " ; cloneAbTest = " + hI(str));
    }

    private void f(File file, File file2) {
        boolean bD = l.bD(file.getAbsolutePath(), file2.getAbsolutePath());
        if (bD) {
            c.deleteFile(file);
        }
        hJ("zip file status = " + bD);
    }
}
