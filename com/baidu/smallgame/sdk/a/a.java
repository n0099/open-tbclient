package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static int bxH = 1;
    private static int bxI = 2;
    private static int bxJ = 3;
    private Map<String, String> bxK = new HashMap();
    private Map<String, String> bxL = new HashMap();
    private SharedPreferences bxM;

    public void b(SharedPreferences sharedPreferences) {
        this.bxM = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == bxH) {
            this.bxK.put(str, str2);
        } else if (i == bxI) {
            this.bxL.put(str, str2);
        } else if (i == bxJ) {
            if (this.bxM != null) {
                this.bxM.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == bxH) {
            str2 = this.bxK.get(str);
        } else if (i == bxI) {
            str2 = this.bxL.get(str);
        } else if (i == bxJ) {
            if (this.bxM != null) {
                str2 = this.bxM.getString(str, "");
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
        this.bxK.clear();
    }
}
