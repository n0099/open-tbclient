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
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private File dXM;
    private SharedPreferences mPref;

    public b() {
        String aWx = aWx();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + aWx);
        }
        if (aWx != null) {
            this.mPref = com.baidu.swan.apps.t.a.avS().getSharedPreferences(aWx, 0);
            this.dXM = new File(aWB(), aWx + ".xml");
        }
        e.dBj.a(new c.a<Long>() { // from class: com.baidu.swan.games.w.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.am.c.a
            /* renamed from: aJY */
            public Long aJZ() throws IllegalStateException {
                return Long.valueOf(b.this.aJW());
            }
        });
    }

    @Nullable
    private String aWx() {
        String aGO = com.baidu.swan.apps.runtime.e.aGO();
        if (TextUtils.isEmpty(aGO)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", aGO);
    }

    private boolean aWy() {
        return this.mPref != null;
    }

    public long aJW() {
        if (this.dXM != null) {
            return this.dXM.length();
        }
        return 0L;
    }

    public long aJX() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (aWy()) {
            return this.mPref.getString(str, str2);
        }
        return null;
    }

    public String[] aWz() {
        if (!aWy()) {
            return new String[0];
        }
        Set<String> keySet = this.mPref.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean putString(String str, String str2) {
        return aWy() && this.mPref.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return aWy() && this.mPref.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean aWA() {
        return aWy() && this.mPref.edit().clear().commit();
    }

    @NonNull
    public static File aWB() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void xy(String str) {
        xz(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void aWC() {
        xz("aigame_storage_");
    }

    private static void xz(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = aWB().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
