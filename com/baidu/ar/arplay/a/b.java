package com.baidu.ar.arplay.a;

import android.content.SharedPreferences;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class b {

    /* renamed from: de  reason: collision with root package name */
    private static int f958de = 1;
    private static int df = 2;
    private static int dg = 3;
    private Map<String, String> dh = new HashMap();
    private Map<String, String> di = new HashMap();
    private SharedPreferences dj;

    public void a(SharedPreferences sharedPreferences) {
        this.dj = sharedPreferences;
    }

    public void clearARMemory() {
        this.dh.clear();
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == f958de) {
            str2 = this.dh.get(str);
        } else if (i == df) {
            str2 = this.di.get(str);
        } else if (i == dg) {
            if (this.dj != null) {
                str2 = this.dj.getString(str, "");
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
        return str2 == null ? "" : str2;
    }

    public void setValue(int i, String str, String str2) {
        if (i == f958de) {
            this.dh.put(str, str2);
        } else if (i == df) {
            this.di.put(str, str2);
        } else if (i == dg) {
            if (this.dj != null) {
                this.dj.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }
}
