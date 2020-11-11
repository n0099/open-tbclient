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
    private File dZu;
    private SharedPreferences mPref;

    public b() {
        String aXf = aXf();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + aXf);
        }
        if (aXf != null) {
            this.mPref = com.baidu.swan.apps.t.a.awA().getSharedPreferences(aXf, 0);
            this.dZu = new File(aXj(), aXf + ".xml");
        }
        e.dCQ.a(new c.a<Long>() { // from class: com.baidu.swan.games.w.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.am.c.a
            /* renamed from: aKG */
            public Long aKH() throws IllegalStateException {
                return Long.valueOf(b.this.aKE());
            }
        });
    }

    @Nullable
    private String aXf() {
        String aHw = com.baidu.swan.apps.runtime.e.aHw();
        if (TextUtils.isEmpty(aHw)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", aHw);
    }

    private boolean aXg() {
        return this.mPref != null;
    }

    public long aKE() {
        if (this.dZu != null) {
            return this.dZu.length();
        }
        return 0L;
    }

    public long aKF() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (aXg()) {
            return this.mPref.getString(str, str2);
        }
        return null;
    }

    public String[] aXh() {
        if (!aXg()) {
            return new String[0];
        }
        Set<String> keySet = this.mPref.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean putString(String str, String str2) {
        return aXg() && this.mPref.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return aXg() && this.mPref.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean aXi() {
        return aXg() && this.mPref.edit().clear().commit();
    }

    @NonNull
    public static File aXj() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void xD(String str) {
        xE(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void aXk() {
        xE("aigame_storage_");
    }

    private static void xE(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = aXj().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
