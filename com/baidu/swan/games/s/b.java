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
    private File aWT;
    private SharedPreferences blH;

    public b() {
        String Tl = Tl();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + Tl);
        }
        if (Tl != null) {
            this.blH = com.baidu.swan.apps.u.a.Eo().getSharedPreferences(Tl, 0);
            this.aWT = new File(Tp(), Tl + ".xml");
        }
        e.bab.a(new c.a<Long>() { // from class: com.baidu.swan.games.s.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ak.c.a
            /* renamed from: NZ */
            public Long Oa() throws IllegalStateException {
                return Long.valueOf(b.this.NX());
            }
        });
    }

    @Nullable
    private String Tl() {
        String Ms = com.baidu.swan.apps.ae.b.Ms();
        String bd = com.baidu.swan.apps.u.a.Et().bd(com.baidu.swan.apps.u.a.Eo());
        if (TextUtils.isEmpty(Ms) || TextUtils.isEmpty(bd)) {
            return null;
        }
        String format = String.format("aigame_storage_%s_%s", Ms, com.baidu.swan.c.b.toMd5(bd.getBytes(), false));
        String bc = com.baidu.swan.apps.u.a.Et().bc(com.baidu.swan.apps.u.a.Eo());
        if (!TextUtils.isEmpty(bc)) {
            String format2 = String.format("aigame_storage_%s_%s", Ms, com.baidu.swan.c.b.toMd5(bc.getBytes(), false));
            if (!new File(Tp(), format2 + ".xml").exists()) {
                format2 = format;
            }
            return format2;
        }
        return format;
    }

    private boolean Tm() {
        return this.blH != null;
    }

    public long NX() {
        if (this.aWT != null) {
            return this.aWT.length();
        }
        return 0L;
    }

    public long NY() {
        return Config.FULL_TRACE_LOG_LIMIT;
    }

    public String getString(String str, String str2) {
        if (Tm()) {
            return this.blH.getString(str, str2);
        }
        return null;
    }

    public String[] Tn() {
        if (!Tm()) {
            return new String[0];
        }
        Set<String> keySet = this.blH.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean bh(String str, String str2) {
        return Tm() && this.blH.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return Tm() && this.blH.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean To() {
        return Tm() && this.blH.edit().clear().commit();
    }

    @NonNull
    public static File Tp() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void jX(String str) {
        jY(String.format("aigame_storage_%s_%s", str, ""));
    }

    private static void jY(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = Tp().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
