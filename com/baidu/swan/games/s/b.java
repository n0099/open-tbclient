package com.baidu.swan.games.s;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ak.c;
import com.baidu.swan.apps.ak.e;
import java.io.File;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private File aVL;
    private SharedPreferences bkw;

    public b() {
        String So = So();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + So);
        }
        if (So != null) {
            this.bkw = com.baidu.swan.apps.u.a.DB().getSharedPreferences(So, 0);
            this.aVL = new File(Ss(), So + ".xml");
        }
        e.aYT.a(new c.a<Long>() { // from class: com.baidu.swan.games.s.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ak.c.a
            /* renamed from: Ng */
            public Long Nh() throws IllegalStateException {
                return Long.valueOf(b.this.Ne());
            }
        });
    }

    @Nullable
    private String So() {
        String LB = com.baidu.swan.apps.ae.b.LB();
        String bd = com.baidu.swan.apps.u.a.DG().bd(com.baidu.swan.apps.u.a.DB());
        if (TextUtils.isEmpty(LB) || TextUtils.isEmpty(bd)) {
            return null;
        }
        String format = String.format("aigame_storage_%s_%s", LB, com.baidu.swan.c.b.toMd5(bd.getBytes(), false));
        String bc = com.baidu.swan.apps.u.a.DG().bc(com.baidu.swan.apps.u.a.DB());
        if (!TextUtils.isEmpty(bc)) {
            String format2 = String.format("aigame_storage_%s_%s", LB, com.baidu.swan.c.b.toMd5(bc.getBytes(), false));
            if (!new File(Ss(), format2 + ".xml").exists()) {
                format2 = format;
            }
            return format2;
        }
        return format;
    }

    private boolean Sp() {
        return this.bkw != null;
    }

    public long Ne() {
        if (this.aVL != null) {
            return this.aVL.length();
        }
        return 0L;
    }

    public long Nf() {
        return Config.FULL_TRACE_LOG_LIMIT;
    }

    public String getString(String str, String str2) {
        if (Sp()) {
            return this.bkw.getString(str, str2);
        }
        return null;
    }

    public String[] Sq() {
        if (!Sp()) {
            return new String[0];
        }
        Set<String> keySet = this.bkw.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean bh(String str, String str2) {
        return Sp() && this.bkw.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return Sp() && this.bkw.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean Sr() {
        return Sp() && this.bkw.edit().clear().commit();
    }

    @NonNull
    public static File Ss() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void jN(String str) {
        jO(String.format("aigame_storage_%s_%s", str, ""));
    }

    private static void jO(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = Ss().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
