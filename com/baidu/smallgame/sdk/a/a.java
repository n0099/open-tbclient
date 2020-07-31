package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class a {
    private Map<String, String> bKC = new HashMap();
    private Map<String, String> bKD = new HashMap();
    private SharedPreferences bKE;
    private static int bKz = 1;
    private static int bKA = 2;
    private static int bKB = 3;

    public void b(SharedPreferences sharedPreferences) {
        this.bKE = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == bKz) {
            this.bKC.put(str, str2);
        } else if (i == bKA) {
            this.bKD.put(str, str2);
        } else if (i == bKB) {
            if (this.bKE != null) {
                this.bKE.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == bKz) {
            str2 = this.bKC.get(str);
        } else if (i == bKA) {
            str2 = this.bKD.get(str);
        } else if (i == bKB) {
            if (this.bKE != null) {
                str2 = this.bKE.getString(str, "");
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
        this.bKC.clear();
    }
}
