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
    private File aSS;
    private SharedPreferences bfh;

    public b() {
        String OX = OX();
        if (OX != null) {
            this.bfh = com.baidu.swan.apps.u.a.Cy().getSharedPreferences(OX, 0);
            this.aSS = new File(Pb(), OX + ".xml");
        }
        e.aVP.a(new c.a<Long>() { // from class: com.baidu.swan.games.q.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ak.c.a
            /* renamed from: KJ */
            public Long KK() throws IllegalStateException {
                return Long.valueOf(b.this.KH());
            }
        });
    }

    @Nullable
    private String OX() {
        com.baidu.swan.apps.u.b.c CD = com.baidu.swan.apps.u.a.CD();
        String Ji = com.baidu.swan.apps.ae.b.Ji();
        String bI = CD != null ? CD.bI(com.baidu.swan.apps.u.a.Cy()) : null;
        String bJ = CD != null ? CD.bJ(com.baidu.swan.apps.u.a.Cy()) : null;
        if (!TextUtils.isEmpty(bI)) {
            bJ = bI;
        }
        String md5 = TextUtils.isEmpty(bJ) ? null : com.baidu.swan.c.c.toMd5(bJ.getBytes(), false);
        if (Ji == null || md5 == null) {
            return null;
        }
        return String.format("aigame_storage_%s_%s", Ji, md5);
    }

    private boolean OY() {
        return this.bfh != null;
    }

    public long KH() {
        if (this.aSS != null) {
            return this.aSS.length();
        }
        return 0L;
    }

    public long KI() {
        return Config.FULL_TRACE_LOG_LIMIT;
    }

    public String getString(String str, String str2) {
        if (OY()) {
            return this.bfh.getString(str, str2);
        }
        return null;
    }

    public String[] OZ() {
        if (!OY()) {
            return new String[0];
        }
        Set<String> keySet = this.bfh.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean be(String str, String str2) {
        return OY() && this.bfh.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return OY() && this.bfh.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean Pa() {
        return OY() && this.bfh.edit().clear().commit();
    }

    @NonNull
    public static File Pb() {
        return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs");
    }

    public static void iV(String str) {
        File[] listFiles = Pb().listFiles();
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
