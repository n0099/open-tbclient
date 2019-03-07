package com.baidu.swan.games.q;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ak.c;
import com.baidu.swan.apps.ak.e;
import java.io.File;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {
    private File aSR;
    private SharedPreferences bfg;

    public b() {
        String OX = OX();
        if (OX != null) {
            this.bfg = com.baidu.swan.apps.u.a.Cy().getSharedPreferences(OX, 0);
            this.aSR = new File(Pb(), OX + ".xml");
        }
        e.aVO.a(new c.a<Long>() { // from class: com.baidu.swan.games.q.b.1
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
        return this.bfg != null;
    }

    public long KH() {
        if (this.aSR != null) {
            return this.aSR.length();
        }
        return 0L;
    }

    public long KI() {
        return 10485760L;
    }

    public String getString(String str, String str2) {
        if (OY()) {
            return this.bfg.getString(str, str2);
        }
        return null;
    }

    public String[] OZ() {
        if (!OY()) {
            return new String[0];
        }
        Set<String> keySet = this.bfg.getAll().keySet();
        String[] strArr = new String[keySet.size()];
        keySet.toArray(strArr);
        return strArr;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean be(String str, String str2) {
        return OY() && this.bfg.edit().putString(str, str2).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean remove(String str) {
        return OY() && this.bfg.edit().remove(str).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean Pa() {
        return OY() && this.bfg.edit().clear().commit();
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
