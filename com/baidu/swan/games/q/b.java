package com.baidu.swan.games.q;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ak.c;
import com.baidu.swan.apps.ak.e;
import java.io.File;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {
    private File aSW;
    private SharedPreferences bfl;

    public b() {
        String OV = OV();
        if (OV != null) {
            this.bfl = com.baidu.swan.apps.u.a.Cw().getSharedPreferences(OV, 0);
            this.aSW = new File(OZ(), OV + ".xml");
        }
        e.aVT.a(new c.a<Long>() { // from class: com.baidu.swan.games.q.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ak.c.a
            /* renamed from: KH */
            public Long KI() throws IllegalStateException {
                return Long.valueOf(b.this.KF());
            }
        });
    }

    @Nullable
    private String OV() {
        com.baidu.swan.apps.u.b.c CB = com.baidu.swan.apps.u.a.CB();
        String Jg = com.baidu.swan.apps.ae.b.Jg();
        String bI = CB != null ? CB.bI(com.baidu.swan.apps.u.a.Cw()) : null;
        String bJ = CB != null ? CB.bJ(com.baidu.swan.apps.u.a.Cw()) : null;
        if (!TextUtils.isEmpty(bI)) {
            bJ = bI;
        }
        String md5 = TextUtils.isEmpty(bJ) ? null : com.baidu.swan.c.c.toMd5(bJ.getBytes(), false);
        if (Jg == null || md5 == null) {
            return null;
        }
        return String.format("aigame_storage_%s_%s", Jg, md5);
    }

    private boolean OW() {
        return this.bfl != null;
    }

    public long KF() {
        if (this.aSW != null) {
            return this.aSW.length();
        }
        return 0L;
    }

    public long KG() {
        return Config.FULL_TRACE_LOG_LIMIT;
    }

    public String getString(String str, String str2) {
        if (OW()) {
            return this.bfl.getString(str, str2);
        }
        return null;
    }

    public String[] OX() {
        if (!OW()) {
            return new String[0];
        }
        Set<String> keySet = this.bfl.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean be(String str, String str2) {
        return OW() && this.bfl.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return OW() && this.bfl.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean OY() {
        return OW() && this.bfl.edit().clear().commit();
    }

    @NonNull
    public static File OZ() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void iW(String str) {
        File[] listFiles = OZ().listFiles();
        if (listFiles != null && !TextUtils.isEmpty(str)) {
            String format = String.format("aigame_storage_%s_%s", str, "");
            for (File file : listFiles) {
                if (file.getName().startsWith(format)) {
                    file.delete();
                }
            }
        }
    }
}
