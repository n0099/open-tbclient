package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static int ajd = 1;
    private static int aje = 2;
    private static int ajf = 3;
    private Map<String, String> ajg = new HashMap();
    private Map<String, String> ajh = new HashMap();
    private SharedPreferences aji;

    public void b(SharedPreferences sharedPreferences) {
        this.aji = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == ajd) {
            this.ajg.put(str, str2);
        } else if (i == aje) {
            this.ajh.put(str, str2);
        } else if (i == ajf) {
            if (this.aji != null) {
                this.aji.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == ajd) {
            str2 = this.ajg.get(str);
        } else if (i == aje) {
            str2 = this.ajh.get(str);
        } else if (i == ajf) {
            if (this.aji != null) {
                str2 = this.aji.getString(str, "");
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
        this.ajg.clear();
    }
}
