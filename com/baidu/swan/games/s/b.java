package com.baidu.swan.games.s;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ak.c;
import com.baidu.swan.apps.ak.e;
import java.io.File;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private File aWv;
    private SharedPreferences blj;

    public b() {
        String Th = Th();
        if (DEBUG) {
            Log.i("SwanGameStorageManager", "preferencesName:" + Th);
        }
        if (Th != null) {
            this.blj = com.baidu.swan.apps.u.a.Ek().getSharedPreferences(Th, 0);
            this.aWv = new File(Tl(), Th + ".xml");
        }
        e.aZD.a(new c.a<Long>() { // from class: com.baidu.swan.games.s.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ak.c.a
            /* renamed from: NV */
            public Long NW() throws IllegalStateException {
                return Long.valueOf(b.this.NT());
            }
        });
    }

    @Nullable
    private String Th() {
        String Mo = com.baidu.swan.apps.ae.b.Mo();
        String bd = com.baidu.swan.apps.u.a.Ep().bd(com.baidu.swan.apps.u.a.Ek());
        if (TextUtils.isEmpty(Mo) || TextUtils.isEmpty(bd)) {
            return null;
        }
        String format = String.format("aigame_storage_%s_%s", Mo, com.baidu.swan.c.b.toMd5(bd.getBytes(), false));
        String bc = com.baidu.swan.apps.u.a.Ep().bc(com.baidu.swan.apps.u.a.Ek());
        if (!TextUtils.isEmpty(bc)) {
            String format2 = String.format("aigame_storage_%s_%s", Mo, com.baidu.swan.c.b.toMd5(bc.getBytes(), false));
            if (!new File(Tl(), format2 + ".xml").exists()) {
                format2 = format;
            }
            return format2;
        }
        return format;
    }

    private boolean Ti() {
        return this.blj != null;
    }

    public long NT() {
        if (this.aWv != null) {
            return this.aWv.length();
        }
        return 0L;
    }

    public long NU() {
        return Config.FULL_TRACE_LOG_LIMIT;
    }

    public String getString(String str, String str2) {
        if (Ti()) {
            return this.blj.getString(str, str2);
        }
        return null;
    }

    public String[] Tj() {
        if (!Ti()) {
            return new String[0];
        }
        Set<String> keySet = this.blj.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean bh(String str, String str2) {
        return Ti() && this.blj.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return Ti() && this.blj.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean Tk() {
        return Ti() && this.blj.edit().clear().commit();
    }

    @NonNull
    public static File Tl() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void jV(String str) {
        jW(String.format("aigame_storage_%s_%s", str, ""));
    }

    private static void jW(String str) {
        File[] listFiles;
        if (str != null && str.startsWith("aigame_storage_") && (listFiles = Tl().listFiles()) != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(str)) {
                    file.delete();
                }
            }
        }
    }
}
