package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static int ajr = 1;
    private static int ajs = 2;
    private static int ajt = 3;
    private Map<String, String> aju = new HashMap();
    private Map<String, String> ajv = new HashMap();
    private SharedPreferences ajw;

    public void b(SharedPreferences sharedPreferences) {
        this.ajw = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == ajr) {
            this.aju.put(str, str2);
        } else if (i == ajs) {
            this.ajv.put(str, str2);
        } else if (i == ajt) {
            if (this.ajw != null) {
                this.ajw.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == ajr) {
            str2 = this.aju.get(str);
        } else if (i == ajs) {
            str2 = this.ajv.get(str);
        } else if (i == ajt) {
            if (this.ajw != null) {
                str2 = this.ajw.getString(str, "");
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
        this.aju.clear();
    }
}
