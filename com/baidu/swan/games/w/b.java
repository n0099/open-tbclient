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
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private File dmU;
    private SharedPreferences mPref;

    public b() {
        String aGA = aGA();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + aGA);
        }
        if (aGA != null) {
            this.mPref = com.baidu.swan.apps.t.a.ahj().getSharedPreferences(aGA, 0);
            this.dmU = new File(aGE(), aGA + ".xml");
        }
        e.cRi.a(new c.a<Long>() { // from class: com.baidu.swan.games.w.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: auK */
            public Long auL() throws IllegalStateException {
                return Long.valueOf(b.this.auI());
            }
        });
    }

    @Nullable
    private String aGA() {
        String arx = com.baidu.swan.apps.runtime.e.arx();
        if (TextUtils.isEmpty(arx)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", arx);
    }

    private boolean aGB() {
        return this.mPref != null;
    }

    public long auI() {
        if (this.dmU != null) {
            return this.dmU.length();
        }
        return 0L;
    }

    public long auJ() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (aGB()) {
            return this.mPref.getString(str, str2);
        }
        return null;
    }

    public String[] aGC() {
        if (!aGB()) {
            return new String[0];
        }
        Set<String> keySet = this.mPref.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean putString(String str, String str2) {
        return aGB() && this.mPref.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return aGB() && this.mPref.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean aGD() {
        return aGB() && this.mPref.edit().clear().commit();
    }

    @NonNull
    public static File aGE() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void tA(String str) {
        tB(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void aGF() {
        tB("aigame_storage_");
    }

    private static void tB(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = aGE().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
