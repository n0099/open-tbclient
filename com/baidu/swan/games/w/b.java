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
    private File dTC;
    private SharedPreferences mPref;

    public b() {
        String aUF = aUF();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + aUF);
        }
        if (aUF != null) {
            this.mPref = com.baidu.swan.apps.t.a.aua().getSharedPreferences(aUF, 0);
            this.dTC = new File(aUJ(), aUF + ".xml");
        }
        e.dwY.a(new c.a<Long>() { // from class: com.baidu.swan.games.w.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.am.c.a
            /* renamed from: aIg */
            public Long aIh() throws IllegalStateException {
                return Long.valueOf(b.this.aIe());
            }
        });
    }

    @Nullable
    private String aUF() {
        String aEW = com.baidu.swan.apps.runtime.e.aEW();
        if (TextUtils.isEmpty(aEW)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", aEW);
    }

    private boolean aUG() {
        return this.mPref != null;
    }

    public long aIe() {
        if (this.dTC != null) {
            return this.dTC.length();
        }
        return 0L;
    }

    public long aIf() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (aUG()) {
            return this.mPref.getString(str, str2);
        }
        return null;
    }

    public String[] aUH() {
        if (!aUG()) {
            return new String[0];
        }
        Set<String> keySet = this.mPref.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean putString(String str, String str2) {
        return aUG() && this.mPref.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return aUG() && this.mPref.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean aUI() {
        return aUG() && this.mPref.edit().clear().commit();
    }

    @NonNull
    public static File aUJ() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void xp(String str) {
        xq(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void aUK() {
        xq("aigame_storage_");
    }

    private static void xq(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = aUJ().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
