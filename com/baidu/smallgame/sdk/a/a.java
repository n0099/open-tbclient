package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes20.dex */
public class a {
    private static int bQb = 1;
    private static int bQc = 2;
    private static int bQd = 3;
    private Map<String, String> bQe = new HashMap();
    private Map<String, String> bQf = new HashMap();
    private SharedPreferences bQg;

    public void b(SharedPreferences sharedPreferences) {
        this.bQg = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == bQb) {
            this.bQe.put(str, str2);
        } else if (i == bQc) {
            this.bQf.put(str, str2);
        } else if (i == bQd) {
            if (this.bQg != null) {
                this.bQg.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == bQb) {
            str2 = this.bQe.get(str);
        } else if (i == bQc) {
            str2 = this.bQf.get(str);
        } else if (i == bQd) {
            if (this.bQg != null) {
                str2 = this.bQg.getString(str, "");
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
        this.bQe.clear();
    }
}
