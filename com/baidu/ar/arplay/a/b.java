package com.baidu.ar.arplay.a;

import android.content.SharedPreferences;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    private static int dj = 1;
    private static int dk = 2;
    private static int dl = 3;
    private Map<String, String> dm = new HashMap();
    private Map<String, String> dn = new HashMap();

    /* renamed from: do  reason: not valid java name */
    private SharedPreferences f0do;

    public void a(SharedPreferences sharedPreferences) {
        this.f0do = sharedPreferences;
    }

    public void clearARMemory() {
        this.dm.clear();
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == dj) {
            str2 = this.dm.get(str);
        } else if (i == dk) {
            str2 = this.dn.get(str);
        } else if (i == dl) {
            if (this.f0do != null) {
                str2 = this.f0do.getString(str, "");
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
        return str2 == null ? "" : str2;
    }

    public void setValue(int i, String str, String str2) {
        if (i == dj) {
            this.dm.put(str, str2);
        } else if (i == dk) {
            this.dn.put(str, str2);
        } else if (i == dl) {
            if (this.f0do != null) {
                this.f0do.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }
}
