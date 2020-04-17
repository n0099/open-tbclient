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
    private File cuJ;
    private SharedPreferences mPref;

    public b() {
        String axW = axW();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + axW);
        }
        if (axW != null) {
            this.mPref = com.baidu.swan.apps.w.a.abO().getSharedPreferences(axW, 0);
            this.cuJ = new File(aya(), axW + ".xml");
        }
        e.cwU.a(new c.a<Long>() { // from class: com.baidu.swan.games.v.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.c.a
            /* renamed from: anu */
            public Long anv() throws IllegalStateException {
                return Long.valueOf(b.this.ans());
            }
        });
    }

    @Nullable
    private String axW() {
        String akP = com.baidu.swan.apps.runtime.e.akP();
        if (TextUtils.isEmpty(akP)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", akP);
    }

    private boolean axX() {
        return this.mPref != null;
    }

    public long ans() {
        if (this.cuJ != null) {
            return this.cuJ.length();
        }
        return 0L;
    }

    public long ant() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (axX()) {
            return this.mPref.getString(str, str2);
        }
        return null;
    }

    public String[] axY() {
        if (!axX()) {
            return new String[0];
        }
        Set<String> keySet = this.mPref.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean putString(String str, String str2) {
        return axX() && this.mPref.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return axX() && this.mPref.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean axZ() {
        return axX() && this.mPref.edit().clear().commit();
    }

    @NonNull
    public static File aya() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void qQ(String str) {
        qR(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void ayb() {
        qR("aigame_storage_");
    }

    private static void qR(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = aya().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
