package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static int ajT = 1;
    private static int ajU = 2;
    private static int ajV = 3;
    private Map<String, String> ajW = new HashMap();
    private Map<String, String> ajX = new HashMap();
    private SharedPreferences ajY;

    public void b(SharedPreferences sharedPreferences) {
        this.ajY = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == ajT) {
            this.ajW.put(str, str2);
        } else if (i == ajU) {
            this.ajX.put(str, str2);
        } else if (i == ajV) {
            if (this.ajY != null) {
                this.ajY.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == ajT) {
            str2 = this.ajW.get(str);
        } else if (i == ajU) {
            str2 = this.ajX.get(str);
        } else if (i == ajV) {
            if (this.ajY != null) {
                str2 = this.ajY.getString(str, "");
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
        this.ajW.clear();
    }
}
