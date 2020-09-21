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
/* loaded from: classes3.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private File dze;
    private SharedPreferences mPref;

    public b() {
        String aQc = aQc();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + aQc);
        }
        if (aQc != null) {
            this.mPref = com.baidu.swan.apps.t.a.apu().getSharedPreferences(aQc, 0);
            this.dze = new File(aQg(), aQc + ".xml");
        }
        e.dco.a(new c.a<Long>() { // from class: com.baidu.swan.games.w.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.am.c.a
            /* renamed from: aDD */
            public Long aDE() throws IllegalStateException {
                return Long.valueOf(b.this.aDB());
            }
        });
    }

    @Nullable
    private String aQc() {
        String aAt = com.baidu.swan.apps.runtime.e.aAt();
        if (TextUtils.isEmpty(aAt)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", aAt);
    }

    private boolean aQd() {
        return this.mPref != null;
    }

    public long aDB() {
        if (this.dze != null) {
            return this.dze.length();
        }
        return 0L;
    }

    public long aDC() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (aQd()) {
            return this.mPref.getString(str, str2);
        }
        return null;
    }

    public String[] aQe() {
        if (!aQd()) {
            return new String[0];
        }
        Set<String> keySet = this.mPref.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean putString(String str, String str2) {
        return aQd() && this.mPref.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return aQd() && this.mPref.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean aQf() {
        return aQd() && this.mPref.edit().clear().commit();
    }

    @NonNull
    public static File aQg() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void wk(String str) {
        wl(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void aQh() {
        wl("aigame_storage_");
    }

    private static void wl(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = aQg().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
