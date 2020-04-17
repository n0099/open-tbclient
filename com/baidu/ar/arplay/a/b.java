package com.baidu.ar.arplay.a;

import android.content.SharedPreferences;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    private static int dq = 1;
    private static int dr = 2;
    private static int ds = 3;
    private Map<String, String> dt = new HashMap();
    private Map<String, String> du = new HashMap();
    private SharedPreferences dv;

    public void a(SharedPreferences sharedPreferences) {
        this.dv = sharedPreferences;
    }

    public void clearARMemory() {
        this.dt.clear();
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == dq) {
            str2 = this.dt.get(str);
        } else if (i == dr) {
            str2 = this.du.get(str);
        } else if (i == ds) {
            if (this.dv != null) {
                str2 = this.dv.getString(str, "");
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
        return str2 == null ? "" : str2;
    }

    public void setValue(int i, String str, String str2) {
        if (i == dq) {
            this.dt.put(str, str2);
        } else if (i == dr) {
            this.du.put(str, str2);
        } else if (i == ds) {
            if (this.dv != null) {
                this.dv.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }
}
