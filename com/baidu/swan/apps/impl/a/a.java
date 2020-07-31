package com.baidu.swan.apps.impl.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.swan.apps.adaptation.a.u;
import com.baidu.swan.d.d;
import com.baidu.swan.games.i.n;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.impl.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0360a {
        private static final a clH = new a();
    }

    public static a agw() {
        return C0360a.clH;
    }

    public void S(Context context, String str) {
        kX("cloneSwanApp: start");
        c(K(context, str), str);
        kX("cloneSwanApp: end");
    }

    public File K(Context context, String str) {
        File file = null;
        if (TextUtils.isEmpty(str)) {
            kX("appKey is empty");
        } else {
            kX("cloneFilesAndMakeZip start, appKey = " + str);
            File file2 = new File(com.baidu.swan.apps.impl.a.a.a.clP + str);
            if (!s(file2)) {
                kX("delete old tmp dir failed");
            } else {
                File agA = com.baidu.swan.apps.impl.a.a.a.agA();
                if (agA == null) {
                    kX("dest zip dir is null");
                } else {
                    file = new File(agA, com.baidu.swan.apps.impl.a.a.a.clV);
                    if (file.exists()) {
                        d.safeDeleteFile(file);
                    }
                    d.createNewFileSafely(file);
                    b(context, str, file2);
                    h(file2.getParentFile(), file);
                    kX("cloneFilesAndMakeZip end, appKey = " + str);
                }
            }
        }
        return file;
    }

    public boolean c(String str, File file) {
        File a = a(str, file, com.baidu.swan.apps.impl.a.a.a.clQ);
        if (a == null) {
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.clK, str);
        if (file2.exists()) {
            File file3 = new File(a, str);
            d.ensureDirectoryExist(file3);
            d.k(file2, file3);
            return true;
        }
        return false;
    }

    public boolean d(String str, File file) {
        File a = a(str, file, com.baidu.swan.apps.impl.a.a.a.clR);
        if (a == null) {
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.clK, str);
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
        File a = a(str, file, com.baidu.swan.apps.impl.a.a.a.clT);
        if (context == null || a == null) {
            return false;
        }
        return a(context, str, a, new File(AppRuntime.getAppContext().getFilesDir(), "swan_prefs"), ".kv") | a(context, str, a, new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"), ".xml");
    }

    public boolean e(String str, File file) {
        File a = a(str, file, com.baidu.swan.apps.impl.a.a.a.clU);
        if (a == null) {
            return false;
        }
        g("ai_apps.db", a);
        g("ai_apps_pms.db", a);
        return true;
    }

    public boolean kW(String str) {
        return true;
    }

    public boolean f(String str, File file) {
        File a = a(str, new File(file, com.baidu.swan.apps.impl.a.a.a.clS), "swan_plugin_workspace");
        if (a != null) {
            File ahb = com.baidu.swan.apps.r.d.ahb();
            if (ahb.exists()) {
                d.k(ahb, a);
            }
        }
        return false;
    }

    public boolean c(final File file, String str) {
        String[] list;
        if (file == null || !file.exists()) {
            kX("no zip file");
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.clK, str);
        String str2 = "-1";
        if (file2.exists() && (list = file2.list()) != null && list.length > 0) {
            str2 = list[0];
        }
        kX("upload file: ready");
        u ahs = com.baidu.swan.apps.t.a.ahs();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("aiappid", str);
        hashMap.put("aiappversion", str2);
        ahs.a(hashMap, file, new u.a() { // from class: com.baidu.swan.apps.impl.a.a.1
            @Override // com.baidu.swan.apps.adaptation.a.u.a
            public void onResult(String str3) {
                if (!com.baidu.swan.apps.b.DEBUG) {
                    d.safeDeleteFile(file);
                }
                a.this.kX("upload file: done. feedback data = " + str3);
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

    private void a(String str, File file, File file2, String str2) {
        if (!TextUtils.isEmpty(str) && file != null && file.exists() && file2 != null && file2.exists()) {
            String str3 = str + str2;
            File file3 = new File(file, str3);
            if (file3.exists()) {
                d.copyFile(file3, new File(file2, str3));
            }
        }
    }

    public void kX(String str) {
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
        boolean d = d(com.baidu.swan.apps.impl.a.a.a.clL, file);
        boolean d2 = d(com.baidu.swan.apps.impl.a.a.a.clM, file);
        boolean a = a(context, str, file);
        boolean e = e(str, file);
        boolean kW = kW(str);
        kX("cloneSwanPkg = " + c + " ; cloneSwanCore = " + d + " ; cloneExtensionCore = " + d2 + " ; cloneSp = " + a + " ; cloneDb = " + e + " ; cloneAbTest = " + kW + " ; cloneDynamicLib = " + f(str, file));
    }

    private void h(File file, File file2) {
        boolean cw = n.cw(file.getAbsolutePath(), file2.getAbsolutePath());
        if (cw) {
            d.deleteFile(file);
        }
        kX("zip file status = " + cw);
    }
}
