package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static int aiZ = 1;
    private static int aja = 2;
    private static int ajb = 3;
    private Map<String, String> ajc = new HashMap();
    private Map<String, String> ajd = new HashMap();
    private SharedPreferences aje;

    public void b(SharedPreferences sharedPreferences) {
        this.aje = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == aiZ) {
            this.ajc.put(str, str2);
        } else if (i == aja) {
            this.ajd.put(str, str2);
        } else if (i == ajb) {
            if (this.aje != null) {
                this.aje.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == aiZ) {
            str2 = this.ajc.get(str);
        } else if (i == aja) {
            str2 = this.ajd.get(str);
        } else if (i == ajb) {
            if (this.aje != null) {
                str2 = this.aje.getString(str, "");
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
        this.ajc.clear();
    }
}
