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
    private File bVR;
    private SharedPreferences mPref;

    public b() {
        String apK = apK();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + apK);
        }
        if (apK != null) {
            this.mPref = com.baidu.swan.apps.w.a.TZ().getSharedPreferences(apK, 0);
            this.bVR = new File(apO(), apK + ".xml");
        }
        e.bYc.a(new c.a<Long>() { // from class: com.baidu.swan.games.v.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.c.a
            /* renamed from: afp */
            public Long afq() throws IllegalStateException {
                return Long.valueOf(b.this.afn());
            }
        });
    }

    @Nullable
    private String apK() {
        String acK = com.baidu.swan.apps.runtime.e.acK();
        if (TextUtils.isEmpty(acK)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", acK);
    }

    private boolean apL() {
        return this.mPref != null;
    }

    public long afn() {
        if (this.bVR != null) {
            return this.bVR.length();
        }
        return 0L;
    }

    public long afo() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (apL()) {
            return this.mPref.getString(str, str2);
        }
        return null;
    }

    public String[] apM() {
        if (!apL()) {
            return new String[0];
        }
        Set<String> keySet = this.mPref.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean putString(String str, String str2) {
        return apL() && this.mPref.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return apL() && this.mPref.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean apN() {
        return apL() && this.mPref.edit().clear().commit();
    }

    @NonNull
    public static File apO() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void pD(String str) {
        pE(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void apP() {
        pE("aigame_storage_");
    }

    private static void pE(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = apO().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
