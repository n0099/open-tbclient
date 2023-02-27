package com.baidu.ar.arplay.a;

import android.content.SharedPreferences;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    public static int dj = 1;
    public static int dk = 2;
    public static int dl = 3;
    public Map<String, String> dm = new HashMap();
    public Map<String, String> dn = new HashMap();

    /* renamed from: do  reason: not valid java name */
    public SharedPreferences f0do;

    public void a(SharedPreferences sharedPreferences) {
        this.f0do = sharedPreferences;
    }

    public void clearARMemory() {
        this.dm.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getValue(int i, String str) {
        String str2;
        Map<String, String> map;
        if (i == dj) {
            map = this.dm;
        } else if (i == dk) {
            map = this.dn;
        } else {
            if (i == dl) {
                SharedPreferences sharedPreferences = this.f0do;
                if (sharedPreferences != null) {
                    str2 = sharedPreferences.getString(str, "");
                    return str2 == null ? "" : str2;
                }
                Log.e("TAG", "prefs data store is null");
            }
            str2 = null;
            if (str2 == null) {
            }
        }
        str2 = map.get(str);
        if (str2 == null) {
        }
    }

    public void setValue(int i, String str, String str2) {
        Map<String, String> map;
        if (i == dj) {
            map = this.dm;
        } else if (i != dk) {
            if (i == dl) {
                SharedPreferences sharedPreferences = this.f0do;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString(str, str2).commit();
                    return;
                } else {
                    Log.e("TAG", "prefs data store is null");
                    return;
                }
            }
            return;
        } else {
            map = this.dn;
        }
        map.put(str, str2);
    }
}
