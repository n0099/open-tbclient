package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes14.dex */
public class a {
    private static int cxW = 1;
    private static int cxX = 2;
    private static int cxY = 3;
    private Map<String, String> cxZ = new HashMap();
    private Map<String, String> cya = new HashMap();
    private SharedPreferences cyb;

    public void b(SharedPreferences sharedPreferences) {
        this.cyb = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == cxW) {
            this.cxZ.put(str, str2);
        } else if (i == cxX) {
            this.cya.put(str, str2);
        } else if (i == cxY) {
            if (this.cyb != null) {
                this.cyb.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == cxW) {
            str2 = this.cxZ.get(str);
        } else if (i == cxX) {
            str2 = this.cya.get(str);
        } else if (i == cxY) {
            if (this.cyb != null) {
                str2 = this.cyb.getString(str, "");
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
        this.cxZ.clear();
    }
}
