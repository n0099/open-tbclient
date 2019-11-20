package com.baidu.swan.games.s;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ak.c;
import com.baidu.swan.apps.ak.e;
import java.io.File;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private SharedPreferences bDE;
    private File bpE;

    public b() {
        String Ya = Ya();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + Ya);
        }
        if (Ya != null) {
            this.bDE = com.baidu.swan.apps.u.a.Jj().getSharedPreferences(Ya, 0);
            this.bpE = new File(Ye(), Ya + ".xml");
        }
        e.bsj.a(new c.a<Long>() { // from class: com.baidu.swan.games.s.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ak.c.a
            /* renamed from: SR */
            public Long SS() throws IllegalStateException {
                return Long.valueOf(b.this.SP());
            }
        });
    }

    @Nullable
    private String Ya() {
        String Rm = com.baidu.swan.apps.ae.b.Rm();
        String bf = com.baidu.swan.apps.u.a.Jo().bf(com.baidu.swan.apps.u.a.Jj());
        if (TextUtils.isEmpty(Rm) || TextUtils.isEmpty(bf)) {
            return null;
        }
        String format = String.format("aigame_storage_%s_%s", Rm, com.baidu.swan.c.b.toMd5(bf.getBytes(), false));
        String be = com.baidu.swan.apps.u.a.Jo().be(com.baidu.swan.apps.u.a.Jj());
        if (!TextUtils.isEmpty(be)) {
            String format2 = String.format("aigame_storage_%s_%s", Rm, com.baidu.swan.c.b.toMd5(be.getBytes(), false));
            if (!new File(Ye(), format2 + ".xml").exists()) {
                format2 = format;
            }
            return format2;
        }
        return format;
    }

    private boolean Yb() {
        return this.bDE != null;
    }

    public long SP() {
        if (this.bpE != null) {
            return this.bpE.length();
        }
        return 0L;
    }

    public long SQ() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (Yb()) {
            return this.bDE.getString(str, str2);
        }
        return null;
    }

    public String[] Yc() {
        if (!Yb()) {
            return new String[0];
        }
        Set<String> keySet = this.bDE.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean bo(String str, String str2) {
        return Yb() && this.bDE.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return Yb() && this.bDE.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean Yd() {
        return Yb() && this.bDE.edit().clear().commit();
    }

    @NonNull
    public static File Ye() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void kz(String str) {
        kA(String.format("aigame_storage_%s_%s", str, ""));
    }

    private static void kA(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = Ye().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
