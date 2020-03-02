package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static int aYT = 1;
    private static int aYU = 2;
    private static int aYV = 3;
    private Map<String, String> aYW = new HashMap();
    private Map<String, String> aYX = new HashMap();
    private SharedPreferences aYY;

    public void b(SharedPreferences sharedPreferences) {
        this.aYY = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == aYT) {
            this.aYW.put(str, str2);
        } else if (i == aYU) {
            this.aYX.put(str, str2);
        } else if (i == aYV) {
            if (this.aYY != null) {
                this.aYY.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == aYT) {
            str2 = this.aYW.get(str);
        } else if (i == aYU) {
            str2 = this.aYX.get(str);
        } else if (i == aYV) {
            if (this.aYY != null) {
                str2 = this.aYY.getString(str, "");
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
        this.aYW.clear();
    }
}
