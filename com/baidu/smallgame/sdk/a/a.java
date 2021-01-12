package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes14.dex */
public class a {
    private static int cyc = 1;
    private static int cyd = 2;
    private static int cye = 3;
    private Map<String, String> cyf = new HashMap();
    private Map<String, String> cyg = new HashMap();
    private SharedPreferences cyh;

    public void b(SharedPreferences sharedPreferences) {
        this.cyh = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == cyc) {
            this.cyf.put(str, str2);
        } else if (i == cyd) {
            this.cyg.put(str, str2);
        } else if (i == cye) {
            if (this.cyh != null) {
                this.cyh.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == cyc) {
            str2 = this.cyf.get(str);
        } else if (i == cyd) {
            str2 = this.cyg.get(str);
        } else if (i == cye) {
            if (this.cyh != null) {
                str2 = this.cyh.getString(str, "");
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
        this.cyf.clear();
    }
}
