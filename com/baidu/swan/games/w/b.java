package com.baidu.swan.games.w;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.al.c;
import com.baidu.swan.apps.al.e;
import java.io.File;
import java.util.Set;
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private File eiY;
    private SharedPreferences mPref;

    public b() {
        String aYd = aYd();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + aYd);
        }
        if (aYd != null) {
            this.mPref = com.baidu.swan.apps.t.a.awy().getSharedPreferences(aYd, 0);
            this.eiY = new File(aYh(), aYd + ".xml");
        }
        e.dMa.a(new c.a<Long>() { // from class: com.baidu.swan.games.w.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.al.c.a
            /* renamed from: aLC */
            public Long aLD() throws IllegalStateException {
                return Long.valueOf(b.this.aLA());
            }
        });
    }

    @Nullable
    private String aYd() {
        String aIt = com.baidu.swan.apps.runtime.e.aIt();
        if (TextUtils.isEmpty(aIt)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", aIt);
    }

    private boolean aYe() {
        return this.mPref != null;
    }

    public long aLA() {
        if (this.eiY != null) {
            return this.eiY.length();
        }
        return 0L;
    }

    public long aLB() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (aYe()) {
            return this.mPref.getString(str, str2);
        }
        return null;
    }

    public String[] aYf() {
        if (!aYe()) {
            return new String[0];
        }
        Set<String> keySet = this.mPref.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean putString(String str, String str2) {
        return aYe() && this.mPref.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return aYe() && this.mPref.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean aYg() {
        return aYe() && this.mPref.edit().clear().commit();
    }

    @NonNull
    public static File aYh() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void wT(String str) {
        wU(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void aYi() {
        wU("aigame_storage_");
    }

    private static void wU(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = aYh().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
