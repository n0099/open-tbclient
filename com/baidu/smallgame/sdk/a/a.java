package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static int bKd = 1;
    private static int bKe = 2;
    private static int bKf = 3;
    private Map<String, String> bKg = new HashMap();
    private Map<String, String> bKh = new HashMap();
    private SharedPreferences bKi;

    public void b(SharedPreferences sharedPreferences) {
        this.bKi = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == bKd) {
            this.bKg.put(str, str2);
        } else if (i == bKe) {
            this.bKh.put(str, str2);
        } else if (i == bKf) {
            if (this.bKi != null) {
                this.bKi.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == bKd) {
            str2 = this.bKg.get(str);
        } else if (i == bKe) {
            str2 = this.bKh.get(str);
        } else if (i == bKf) {
            if (this.bKi != null) {
                str2 = this.bKi.getString(str, "");
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
        this.bKg.clear();
    }
}
