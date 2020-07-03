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
    private File dhl;
    private SharedPreferences mPref;

    public b() {
        String aCT = aCT();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + aCT);
        }
        if (aCT != null) {
            this.mPref = com.baidu.swan.apps.u.a.afX().getSharedPreferences(aCT, 0);
            this.dhl = new File(aCX(), aCT + ".xml");
        }
        e.cNN.a(new c.a<Long>() { // from class: com.baidu.swan.games.w.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: asJ */
            public Long asK() throws IllegalStateException {
                return Long.valueOf(b.this.asH());
            }
        });
    }

    @Nullable
    private String aCT() {
        String apO = com.baidu.swan.apps.runtime.e.apO();
        if (TextUtils.isEmpty(apO)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", apO);
    }

    private boolean aCU() {
        return this.mPref != null;
    }

    public long asH() {
        if (this.dhl != null) {
            return this.dhl.length();
        }
        return 0L;
    }

    public long asI() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (aCU()) {
            return this.mPref.getString(str, str2);
        }
        return null;
    }

    public String[] aCV() {
        if (!aCU()) {
            return new String[0];
        }
        Set<String> keySet = this.mPref.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean putString(String str, String str2) {
        return aCU() && this.mPref.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return aCU() && this.mPref.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean aCW() {
        return aCU() && this.mPref.edit().clear().commit();
    }

    @NonNull
    public static File aCX() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void sC(String str) {
        sD(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void aCY() {
        sD("aigame_storage_");
    }

    private static void sD(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = aCX().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
