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
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private File bRz;
    private SharedPreferences mPref;

    public b() {
        String anr = anr();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + anr);
        }
        if (anr != null) {
            this.mPref = com.baidu.swan.apps.w.a.RG().getSharedPreferences(anr, 0);
            this.bRz = new File(anv(), anr + ".xml");
        }
        e.bTL.a(new c.a<Long>() { // from class: com.baidu.swan.games.v.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.c.a
            /* renamed from: acW */
            public Long acX() throws IllegalStateException {
                return Long.valueOf(b.this.acU());
            }
        });
    }

    @Nullable
    private String anr() {
        String aar = com.baidu.swan.apps.runtime.e.aar();
        if (TextUtils.isEmpty(aar)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", aar);
    }

    private boolean ans() {
        return this.mPref != null;
    }

    public long acU() {
        if (this.bRz != null) {
            return this.bRz.length();
        }
        return 0L;
    }

    public long acV() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (ans()) {
            return this.mPref.getString(str, str2);
        }
        return null;
    }

    public String[] ant() {
        if (!ans()) {
            return new String[0];
        }
        Set<String> keySet = this.mPref.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean putString(String str, String str2) {
        return ans() && this.mPref.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return ans() && this.mPref.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean anu() {
        return ans() && this.mPref.edit().clear().commit();
    }

    @NonNull
    public static File anv() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void pp(String str) {
        pq(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void anw() {
        pq("aigame_storage_");
    }

    private static void pq(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = anv().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
