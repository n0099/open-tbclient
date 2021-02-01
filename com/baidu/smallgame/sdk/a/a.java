package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes15.dex */
public class a {
    private Map<String, String> cAB = new HashMap();
    private Map<String, String> cAC = new HashMap();
    private SharedPreferences cAD;
    private static int cAy = 1;
    private static int cAz = 2;
    private static int cAA = 3;

    public void b(SharedPreferences sharedPreferences) {
        this.cAD = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == cAy) {
            this.cAB.put(str, str2);
        } else if (i == cAz) {
            this.cAC.put(str, str2);
        } else if (i == cAA) {
            if (this.cAD != null) {
                this.cAD.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == cAy) {
            str2 = this.cAB.get(str);
        } else if (i == cAz) {
            str2 = this.cAC.get(str);
        } else if (i == cAA) {
            if (this.cAD != null) {
                str2 = this.cAD.getString(str, "");
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
        this.cAB.clear();
    }
}
