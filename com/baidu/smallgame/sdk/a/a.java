package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static int aYU = 1;
    private static int aYV = 2;
    private static int aYW = 3;
    private Map<String, String> aYX = new HashMap();
    private Map<String, String> aYY = new HashMap();
    private SharedPreferences aYZ;

    public void b(SharedPreferences sharedPreferences) {
        this.aYZ = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == aYU) {
            this.aYX.put(str, str2);
        } else if (i == aYV) {
            this.aYY.put(str, str2);
        } else if (i == aYW) {
            if (this.aYZ != null) {
                this.aYZ.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == aYU) {
            str2 = this.aYX.get(str);
        } else if (i == aYV) {
            str2 = this.aYY.get(str);
        } else if (i == aYW) {
            if (this.aYZ != null) {
                str2 = this.aYZ.getString(str, "");
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
        this.aYX.clear();
    }
}
