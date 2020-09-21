package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class a {
    private static int bSb = 1;
    private static int bSc = 2;
    private static int bSd = 3;
    private Map<String, String> bSe = new HashMap();
    private Map<String, String> bSf = new HashMap();
    private SharedPreferences bSg;

    public void b(SharedPreferences sharedPreferences) {
        this.bSg = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == bSb) {
            this.bSe.put(str, str2);
        } else if (i == bSc) {
            this.bSf.put(str, str2);
        } else if (i == bSd) {
            if (this.bSg != null) {
                this.bSg.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == bSb) {
            str2 = this.bSe.get(str);
        } else if (i == bSc) {
            str2 = this.bSf.get(str);
        } else if (i == bSd) {
            if (this.bSg != null) {
                str2 = this.bSg.getString(str, "");
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
        this.bSe.clear();
    }
}
