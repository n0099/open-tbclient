package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static int aZh = 1;
    private static int aZi = 2;
    private static int aZj = 3;
    private Map<String, String> aZk = new HashMap();
    private Map<String, String> aZl = new HashMap();
    private SharedPreferences aZm;

    public void b(SharedPreferences sharedPreferences) {
        this.aZm = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == aZh) {
            this.aZk.put(str, str2);
        } else if (i == aZi) {
            this.aZl.put(str, str2);
        } else if (i == aZj) {
            if (this.aZm != null) {
                this.aZm.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == aZh) {
            str2 = this.aZk.get(str);
        } else if (i == aZi) {
            str2 = this.aZl.get(str);
        } else if (i == aZj) {
            if (this.aZm != null) {
                str2 = this.aZm.getString(str, "");
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
        this.aZk.clear();
    }
}
