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
/* loaded from: classes9.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private File bQP;
    private SharedPreferences mPref;

    public b() {
        String amY = amY();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + amY);
        }
        if (amY != null) {
            this.mPref = com.baidu.swan.apps.w.a.Rk().getSharedPreferences(amY, 0);
            this.bQP = new File(anc(), amY + ".xml");
        }
        e.bTz.a(new c.a<Long>() { // from class: com.baidu.swan.games.v.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.c.a
            /* renamed from: acz */
            public Long acA() throws IllegalStateException {
                return Long.valueOf(b.this.acx());
            }
        });
    }

    @Nullable
    private String amY() {
        String ZU = com.baidu.swan.apps.runtime.e.ZU();
        if (TextUtils.isEmpty(ZU)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", ZU);
    }

    private boolean amZ() {
        return this.mPref != null;
    }

    public long acx() {
        if (this.bQP != null) {
            return this.bQP.length();
        }
        return 0L;
    }

    public long acy() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (amZ()) {
            return this.mPref.getString(str, str2);
        }
        return null;
    }

    public String[] ana() {
        if (!amZ()) {
            return new String[0];
        }
        Set<String> keySet = this.mPref.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean putString(String str, String str2) {
        return amZ() && this.mPref.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return amZ() && this.mPref.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean anb() {
        return amZ() && this.mPref.edit().clear().commit();
    }

    @NonNull
    public static File anc() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void pm(String str) {
        pn(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void and() {
        pn("aigame_storage_");
    }

    private static void pn(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = anc().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
