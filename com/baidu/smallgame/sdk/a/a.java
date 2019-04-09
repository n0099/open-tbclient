package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static int aje = 1;
    private static int ajf = 2;
    private static int ajg = 3;
    private Map<String, String> ajh = new HashMap();
    private Map<String, String> aji = new HashMap();
    private SharedPreferences ajj;

    public void b(SharedPreferences sharedPreferences) {
        this.ajj = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == aje) {
            this.ajh.put(str, str2);
        } else if (i == ajf) {
            this.aji.put(str, str2);
        } else if (i == ajg) {
            if (this.ajj != null) {
                this.ajj.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == aje) {
            str2 = this.ajh.get(str);
        } else if (i == ajf) {
            str2 = this.aji.get(str);
        } else if (i == ajg) {
            if (this.ajj != null) {
                str2 = this.ajj.getString(str, "");
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
        this.ajh.clear();
    }
}
