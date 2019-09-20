package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static int akr = 1;
    private static int aks = 2;
    private static int akt = 3;
    private Map<String, String> aku = new HashMap();
    private Map<String, String> akv = new HashMap();
    private SharedPreferences akw;

    public void b(SharedPreferences sharedPreferences) {
        this.akw = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == akr) {
            this.aku.put(str, str2);
        } else if (i == aks) {
            this.akv.put(str, str2);
        } else if (i == akt) {
            if (this.akw != null) {
                this.akw.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == akr) {
            str2 = this.aku.get(str);
        } else if (i == aks) {
            str2 = this.akv.get(str);
        } else if (i == akt) {
            if (this.akw != null) {
                str2 = this.akw.getString(str, "");
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public void clearARMemory() {
        this.aku.clear();
    }
}
