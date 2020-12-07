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
/* loaded from: classes25.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private File eeL;
    private SharedPreferences mPref;

    public b() {
        String aZC = aZC();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + aZC);
        }
        if (aZC != null) {
            this.mPref = com.baidu.swan.apps.t.a.aza().getSharedPreferences(aZC, 0);
            this.eeL = new File(aZG(), aZC + ".xml");
        }
        e.dIh.a(new c.a<Long>() { // from class: com.baidu.swan.games.w.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.am.c.a
            /* renamed from: aNf */
            public Long aNg() throws IllegalStateException {
                return Long.valueOf(b.this.aNd());
            }
        });
    }

    @Nullable
    private String aZC() {
        String aJW = com.baidu.swan.apps.runtime.e.aJW();
        if (TextUtils.isEmpty(aJW)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", aJW);
    }

    private boolean aZD() {
        return this.mPref != null;
    }

    public long aNd() {
        if (this.eeL != null) {
            return this.eeL.length();
        }
        return 0L;
    }

    public long aNe() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (aZD()) {
            return this.mPref.getString(str, str2);
        }
        return null;
    }

    public String[] aZE() {
        if (!aZD()) {
            return new String[0];
        }
        Set<String> keySet = this.mPref.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean putString(String str, String str2) {
        return aZD() && this.mPref.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return aZD() && this.mPref.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean aZF() {
        return aZD() && this.mPref.edit().clear().commit();
    }

    @NonNull
    public static File aZG() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void yf(String str) {
        yg(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void aZH() {
        yg("aigame_storage_");
    }

    private static void yg(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = aZG().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
