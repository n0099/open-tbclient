package com.baidu.swan.games.v;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ap.c;
import com.baidu.swan.apps.ap.e;
import java.io.File;
import java.util.Set;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private File bVF;
    private SharedPreferences mPref;

    public b() {
        String apH = apH();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + apH);
        }
        if (apH != null) {
            this.mPref = com.baidu.swan.apps.w.a.TW().getSharedPreferences(apH, 0);
            this.bVF = new File(apL(), apH + ".xml");
        }
        e.bXQ.a(new c.a<Long>() { // from class: com.baidu.swan.games.v.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.c.a
            /* renamed from: afm */
            public Long afn() throws IllegalStateException {
                return Long.valueOf(b.this.afk());
            }
        });
    }

    @Nullable
    private String apH() {
        String acH = com.baidu.swan.apps.runtime.e.acH();
        if (TextUtils.isEmpty(acH)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", acH);
    }

    private boolean apI() {
        return this.mPref != null;
    }

    public long afk() {
        if (this.bVF != null) {
            return this.bVF.length();
        }
        return 0L;
    }

    public long afl() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (apI()) {
            return this.mPref.getString(str, str2);
        }
        return null;
    }

    public String[] apJ() {
        if (!apI()) {
            return new String[0];
        }
        Set<String> keySet = this.mPref.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean putString(String str, String str2) {
        return apI() && this.mPref.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return apI() && this.mPref.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean apK() {
        return apI() && this.mPref.edit().clear().commit();
    }

    @NonNull
    public static File apL() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void pE(String str) {
        pF(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void apM() {
        pF("aigame_storage_");
    }

    private static void pF(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = apL().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
