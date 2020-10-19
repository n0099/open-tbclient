package com.baidu.swan.games.w;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.am.c;
import com.baidu.swan.apps.am.e;
import java.io.File;
import java.util.Set;
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private File dLf;
    private SharedPreferences mPref;

    public b() {
        String aSL = aSL();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + aSL);
        }
        if (aSL != null) {
            this.mPref = com.baidu.swan.apps.t.a.asf().getSharedPreferences(aSL, 0);
            this.dLf = new File(aSP(), aSL + ".xml");
        }
        e.doy.a(new c.a<Long>() { // from class: com.baidu.swan.games.w.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.am.c.a
            /* renamed from: aGm */
            public Long aGn() throws IllegalStateException {
                return Long.valueOf(b.this.aGk());
            }
        });
    }

    @Nullable
    private String aSL() {
        String aDc = com.baidu.swan.apps.runtime.e.aDc();
        if (TextUtils.isEmpty(aDc)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", aDc);
    }

    private boolean aSM() {
        return this.mPref != null;
    }

    public long aGk() {
        if (this.dLf != null) {
            return this.dLf.length();
        }
        return 0L;
    }

    public long aGl() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (aSM()) {
            return this.mPref.getString(str, str2);
        }
        return null;
    }

    public String[] aSN() {
        if (!aSM()) {
            return new String[0];
        }
        Set<String> keySet = this.mPref.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean putString(String str, String str2) {
        return aSM() && this.mPref.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return aSM() && this.mPref.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean aSO() {
        return aSM() && this.mPref.edit().clear().commit();
    }

    @NonNull
    public static File aSP() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void wW(String str) {
        wX(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void aSQ() {
        wX("aigame_storage_");
    }

    private static void wX(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = aSP().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
