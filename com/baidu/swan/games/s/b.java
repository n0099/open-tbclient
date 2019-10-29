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
    private SharedPreferences bEv;
    private File bpW;

    public b() {
        String Yc = Yc();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + Yc);
        }
        if (Yc != null) {
            this.bEv = com.baidu.swan.apps.u.a.Ji().getSharedPreferences(Yc, 0);
            this.bpW = new File(Yg(), Yc + ".xml");
        }
        e.bta.a(new c.a<Long>() { // from class: com.baidu.swan.games.s.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ak.c.a
            /* renamed from: SP */
            public Long SQ() throws IllegalStateException {
                return Long.valueOf(b.this.SN());
            }
        });
    }

    @Nullable
    private String Yc() {
        String Rk = com.baidu.swan.apps.ae.b.Rk();
        String bf = com.baidu.swan.apps.u.a.Jn().bf(com.baidu.swan.apps.u.a.Ji());
        if (TextUtils.isEmpty(Rk) || TextUtils.isEmpty(bf)) {
            return null;
        }
        String format = String.format("aigame_storage_%s_%s", Rk, com.baidu.swan.c.b.toMd5(bf.getBytes(), false));
        String be = com.baidu.swan.apps.u.a.Jn().be(com.baidu.swan.apps.u.a.Ji());
        if (!TextUtils.isEmpty(be)) {
            String format2 = String.format("aigame_storage_%s_%s", Rk, com.baidu.swan.c.b.toMd5(be.getBytes(), false));
            if (!new File(Yg(), format2 + ".xml").exists()) {
                format2 = format;
            }
            return format2;
        }
        return format;
    }

    private boolean Yd() {
        return this.bEv != null;
    }

    public long SN() {
        if (this.bpW != null) {
            return this.bpW.length();
        }
        return 0L;
    }

    public long SO() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (Yd()) {
            return this.bEv.getString(str, str2);
        }
        return null;
    }

    public String[] Ye() {
        if (!Yd()) {
            return new String[0];
        }
        Set<String> keySet = this.bEv.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean bo(String str, String str2) {
        return Yd() && this.bEv.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return Yd() && this.bEv.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean Yf() {
        return Yd() && this.bEv.edit().clear().commit();
    }

    @NonNull
    public static File Yg() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void kz(String str) {
        kA(String.format("aigame_storage_%s_%s", str, ""));
    }

    private static void kA(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = Yg().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
