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
/* loaded from: classes9.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private File elf;
    private SharedPreferences mPref;

    public b() {
        String aYp = aYp();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + aYp);
        }
        if (aYp != null) {
            this.mPref = com.baidu.swan.apps.t.a.awW().getSharedPreferences(aYp, 0);
            this.elf = new File(aYt(), aYp + ".xml");
        }
        e.dOe.a(new c.a<Long>() { // from class: com.baidu.swan.games.w.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.al.c.a
            /* renamed from: aLV */
            public Long aLW() throws IllegalStateException {
                return Long.valueOf(b.this.aLT());
            }
        });
    }

    @Nullable
    private String aYp() {
        String aIM = com.baidu.swan.apps.runtime.e.aIM();
        if (TextUtils.isEmpty(aIM)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", aIM);
    }

    private boolean aYq() {
        return this.mPref != null;
    }

    public long aLT() {
        if (this.elf != null) {
            return this.elf.length();
        }
        return 0L;
    }

    public long aLU() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (aYq()) {
            return this.mPref.getString(str, str2);
        }
        return null;
    }

    public String[] aYr() {
        if (!aYq()) {
            return new String[0];
        }
        Set<String> keySet = this.mPref.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean putString(String str, String str2) {
        return aYq() && this.mPref.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return aYq() && this.mPref.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean aYs() {
        return aYq() && this.mPref.edit().clear().commit();
    }

    @NonNull
    public static File aYt() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void xm(String str) {
        xn(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void aYu() {
        xn("aigame_storage_");
    }

    private static void xn(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = aYt().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
