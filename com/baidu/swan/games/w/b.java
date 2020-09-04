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
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private File dxd;
    private SharedPreferences mPref;

    public b() {
        String aPr = aPr();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + aPr);
        }
        if (aPr != null) {
            this.mPref = com.baidu.swan.apps.t.a.aoJ().getSharedPreferences(aPr, 0);
            this.dxd = new File(aPv(), aPr + ".xml");
        }
        e.dam.a(new c.a<Long>() { // from class: com.baidu.swan.games.w.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.am.c.a
            /* renamed from: aCT */
            public Long aCU() throws IllegalStateException {
                return Long.valueOf(b.this.aCR());
            }
        });
    }

    @Nullable
    private String aPr() {
        String azK = com.baidu.swan.apps.runtime.e.azK();
        if (TextUtils.isEmpty(azK)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", azK);
    }

    private boolean aPs() {
        return this.mPref != null;
    }

    public long aCR() {
        if (this.dxd != null) {
            return this.dxd.length();
        }
        return 0L;
    }

    public long aCS() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (aPs()) {
            return this.mPref.getString(str, str2);
        }
        return null;
    }

    public String[] aPt() {
        if (!aPs()) {
            return new String[0];
        }
        Set<String> keySet = this.mPref.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean putString(String str, String str2) {
        return aPs() && this.mPref.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return aPs() && this.mPref.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean aPu() {
        return aPs() && this.mPref.edit().clear().commit();
    }

    @NonNull
    public static File aPv() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void vR(String str) {
        vS(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void aPw() {
        vS("aigame_storage_");
    }

    private static void vS(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = aPv().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
