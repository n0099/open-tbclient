package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static int aYS = 1;
    private static int aYT = 2;
    private static int aYU = 3;
    private Map<String, String> aYV = new HashMap();
    private Map<String, String> aYW = new HashMap();
    private SharedPreferences aYX;

    public void b(SharedPreferences sharedPreferences) {
        this.aYX = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == aYS) {
            this.aYV.put(str, str2);
        } else if (i == aYT) {
            this.aYW.put(str, str2);
        } else if (i == aYU) {
            if (this.aYX != null) {
                this.aYX.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == aYS) {
            str2 = this.aYV.get(str);
        } else if (i == aYT) {
            str2 = this.aYW.get(str);
        } else if (i == aYU) {
            if (this.aYX != null) {
                str2 = this.aYX.getString(str, "");
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
        this.aYV.clear();
    }
}
