package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes20.dex */
public class a {
    private static int bPX = 1;
    private static int bPY = 2;
    private static int bPZ = 3;
    private Map<String, String> bQa = new HashMap();
    private Map<String, String> bQb = new HashMap();
    private SharedPreferences bQc;

    public void b(SharedPreferences sharedPreferences) {
        this.bQc = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == bPX) {
            this.bQa.put(str, str2);
        } else if (i == bPY) {
            this.bQb.put(str, str2);
        } else if (i == bPZ) {
            if (this.bQc != null) {
                this.bQc.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == bPX) {
            str2 = this.bQa.get(str);
        } else if (i == bPY) {
            str2 = this.bQb.get(str);
        } else if (i == bPZ) {
            if (this.bQc != null) {
                str2 = this.bQc.getString(str, "");
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
        this.bQa.clear();
    }
}
