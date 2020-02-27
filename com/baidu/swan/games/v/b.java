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
    private File bVE;
    private SharedPreferences mPref;

    public b() {
        String apF = apF();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + apF);
        }
        if (apF != null) {
            this.mPref = com.baidu.swan.apps.w.a.TU().getSharedPreferences(apF, 0);
            this.bVE = new File(apJ(), apF + ".xml");
        }
        e.bXP.a(new c.a<Long>() { // from class: com.baidu.swan.games.v.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.c.a
            /* renamed from: afk */
            public Long afl() throws IllegalStateException {
                return Long.valueOf(b.this.afi());
            }
        });
    }

    @Nullable
    private String apF() {
        String acF = com.baidu.swan.apps.runtime.e.acF();
        if (TextUtils.isEmpty(acF)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", acF);
    }

    private boolean apG() {
        return this.mPref != null;
    }

    public long afi() {
        if (this.bVE != null) {
            return this.bVE.length();
        }
        return 0L;
    }

    public long afj() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (apG()) {
            return this.mPref.getString(str, str2);
        }
        return null;
    }

    public String[] apH() {
        if (!apG()) {
            return new String[0];
        }
        Set<String> keySet = this.mPref.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean putString(String str, String str2) {
        return apG() && this.mPref.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return apG() && this.mPref.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean apI() {
        return apG() && this.mPref.edit().clear().commit();
    }

    @NonNull
    public static File apJ() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void pE(String str) {
        pF(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void apK() {
        pF("aigame_storage_");
    }

    private static void pF(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = apJ().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
