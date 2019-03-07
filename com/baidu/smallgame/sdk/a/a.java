package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static int aiY = 1;
    private static int aiZ = 2;
    private static int aja = 3;
    private Map<String, String> ajb = new HashMap();
    private Map<String, String> ajc = new HashMap();
    private SharedPreferences ajd;

    public void b(SharedPreferences sharedPreferences) {
        this.ajd = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == aiY) {
            this.ajb.put(str, str2);
        } else if (i == aiZ) {
            this.ajc.put(str, str2);
        } else if (i == aja) {
            if (this.ajd != null) {
                this.ajd.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == aiY) {
            str2 = this.ajb.get(str);
        } else if (i == aiZ) {
            str2 = this.ajc.get(str);
        } else if (i == aja) {
            if (this.ajd != null) {
                str2 = this.ajd.getString(str, "");
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
        this.ajb.clear();
    }
}
