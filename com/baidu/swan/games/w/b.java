package com.baidu.swan.games.w;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.c;
import com.baidu.swan.apps.an.e;
import java.io.File;
import java.util.Set;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private File dcz;
    private SharedPreferences mPref;

    public b() {
        String aBN = aBN();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + aBN);
        }
        if (aBN != null) {
            this.mPref = com.baidu.swan.apps.u.a.aeR().getSharedPreferences(aBN, 0);
            this.dcz = new File(aBR(), aBN + ".xml");
        }
        e.cJd.a(new c.a<Long>() { // from class: com.baidu.swan.games.w.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: arC */
            public Long arD() throws IllegalStateException {
                return Long.valueOf(b.this.arA());
            }
        });
    }

    @Nullable
    private String aBN() {
        String aoH = com.baidu.swan.apps.runtime.e.aoH();
        if (TextUtils.isEmpty(aoH)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", aoH);
    }

    private boolean aBO() {
        return this.mPref != null;
    }

    public long arA() {
        if (this.dcz != null) {
            return this.dcz.length();
        }
        return 0L;
    }

    public long arB() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (aBO()) {
            return this.mPref.getString(str, str2);
        }
        return null;
    }

    public String[] aBP() {
        if (!aBO()) {
            return new String[0];
        }
        Set<String> keySet = this.mPref.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean putString(String str, String str2) {
        return aBO() && this.mPref.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return aBO() && this.mPref.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean aBQ() {
        return aBO() && this.mPref.edit().clear().commit();
    }

    @NonNull
    public static File aBR() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void su(String str) {
        sv(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void aBS() {
        sv("aigame_storage_");
    }

    private static void sv(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = aBR().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
