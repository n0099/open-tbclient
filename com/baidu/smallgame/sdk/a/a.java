package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static int aDv = 1;
    private static int aDw = 2;
    private static int aDx = 3;
    private SharedPreferences aDA;
    private Map<String, String> aDy = new HashMap();
    private Map<String, String> aDz = new HashMap();

    public void b(SharedPreferences sharedPreferences) {
        this.aDA = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == aDv) {
            this.aDy.put(str, str2);
        } else if (i == aDw) {
            this.aDz.put(str, str2);
        } else if (i == aDx) {
            if (this.aDA != null) {
                this.aDA.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == aDv) {
            str2 = this.aDy.get(str);
        } else if (i == aDw) {
            str2 = this.aDz.get(str);
        } else if (i == aDx) {
            if (this.aDA != null) {
                str2 = this.aDA.getString(str, "");
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
        this.aDy.clear();
    }
}
