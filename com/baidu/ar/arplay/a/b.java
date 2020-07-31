package com.baidu.ar.arplay.a;

import android.content.SharedPreferences;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class b {
    private static int dC = 1;
    private static int dD = 2;
    private static int dE = 3;
    private Map<String, String> dF = new HashMap();
    private Map<String, String> dG = new HashMap();
    private SharedPreferences dH;

    public void a(SharedPreferences sharedPreferences) {
        this.dH = sharedPreferences;
    }

    public void clearARMemory() {
        this.dF.clear();
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == dC) {
            str2 = this.dF.get(str);
        } else if (i == dD) {
            str2 = this.dG.get(str);
        } else if (i == dE) {
            if (this.dH != null) {
                str2 = this.dH.getString(str, "");
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
        return str2 == null ? "" : str2;
    }

    public void setValue(int i, String str, String str2) {
        if (i == dC) {
            this.dF.put(str, str2);
        } else if (i == dD) {
            this.dG.put(str, str2);
        } else if (i == dE) {
            if (this.dH != null) {
                this.dH.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }
}
