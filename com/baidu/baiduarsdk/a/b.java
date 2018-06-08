package com.baidu.baiduarsdk.a;

import android.content.SharedPreferences;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    private static int a = 1;
    private static int b = 2;
    private static int c = 3;
    private Map<String, String> d = new HashMap();
    private Map<String, String> e = new HashMap();
    private SharedPreferences f;

    public String a(int i, String str) {
        String str2 = null;
        if (i == a) {
            str2 = this.d.get(str);
        } else if (i == b) {
            str2 = this.e.get(str);
        } else if (i == c) {
            if (this.f != null) {
                str2 = this.f.getString(str, "");
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
        return str2 == null ? "" : str2;
    }

    public void a() {
        this.d.clear();
    }

    public void a(int i, String str, String str2) {
        if (i == a) {
            this.d.put(str, str2);
        } else if (i == b) {
            this.e.put(str, str2);
        } else if (i == c) {
            if (this.f != null) {
                this.f.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public void a(SharedPreferences sharedPreferences) {
        this.f = sharedPreferences;
    }
}
