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
    private File emG;
    private SharedPreferences mPref;

    public b() {
        String aYs = aYs();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + aYs);
        }
        if (aYs != null) {
            this.mPref = com.baidu.swan.apps.t.a.awZ().getSharedPreferences(aYs, 0);
            this.emG = new File(aYw(), aYs + ".xml");
        }
        e.dPF.a(new c.a<Long>() { // from class: com.baidu.swan.games.w.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.al.c.a
            /* renamed from: aLY */
            public Long aLZ() throws IllegalStateException {
                return Long.valueOf(b.this.aLW());
            }
        });
    }

    @Nullable
    private String aYs() {
        String aIP = com.baidu.swan.apps.runtime.e.aIP();
        if (TextUtils.isEmpty(aIP)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", aIP);
    }

    private boolean aYt() {
        return this.mPref != null;
    }

    public long aLW() {
        if (this.emG != null) {
            return this.emG.length();
        }
        return 0L;
    }

    public long aLX() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (aYt()) {
            return this.mPref.getString(str, str2);
        }
        return null;
    }

    public String[] aYu() {
        if (!aYt()) {
            return new String[0];
        }
        Set<String> keySet = this.mPref.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean putString(String str, String str2) {
        return aYt() && this.mPref.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return aYt() && this.mPref.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean aYv() {
        return aYt() && this.mPref.edit().clear().commit();
    }

    @NonNull
    public static File aYw() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void xt(String str) {
        xu(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void aYx() {
        xu("aigame_storage_");
    }

    private static void xu(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = aYw().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
