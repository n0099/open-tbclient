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
    private File enM;
    private SharedPreferences mPref;

    public b() {
        String bbX = bbX();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + bbX);
        }
        if (bbX != null) {
            this.mPref = com.baidu.swan.apps.t.a.aAs().getSharedPreferences(bbX, 0);
            this.enM = new File(bcb(), bbX + ".xml");
        }
        e.dQM.a(new c.a<Long>() { // from class: com.baidu.swan.games.w.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.al.c.a
            /* renamed from: aPw */
            public Long aPx() throws IllegalStateException {
                return Long.valueOf(b.this.aPu());
            }
        });
    }

    @Nullable
    private String bbX() {
        String aMn = com.baidu.swan.apps.runtime.e.aMn();
        if (TextUtils.isEmpty(aMn)) {
            return null;
        }
        return String.format("aigame_storage_%s_anonymous", aMn);
    }

    private boolean bbY() {
        return this.mPref != null;
    }

    public long aPu() {
        if (this.enM != null) {
            return this.enM.length();
        }
        return 0L;
    }

    public long aPv() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (bbY()) {
            return this.mPref.getString(str, str2);
        }
        return null;
    }

    public String[] bbZ() {
        if (!bbY()) {
            return new String[0];
        }
        Set<String> keySet = this.mPref.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean putString(String str, String str2) {
        return bbY() && this.mPref.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return bbY() && this.mPref.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean bca() {
        return bbY() && this.mPref.edit().clear().commit();
    }

    @NonNull
    public static File bcb() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void ye(String str) {
        yf(String.format("aigame_storage_%s_anonymous", str, ""));
    }

    public static void bcc() {
        yf("aigame_storage_");
    }

    private static void yf(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = bcb().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
