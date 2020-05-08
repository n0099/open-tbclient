package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static int bxM = 1;
    private static int bxN = 2;
    private static int bxO = 3;
    private Map<String, String> bxP = new HashMap();
    private Map<String, String> bxQ = new HashMap();
    private SharedPreferences bxR;

    public void b(SharedPreferences sharedPreferences) {
        this.bxR = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == bxM) {
            this.bxP.put(str, str2);
        } else if (i == bxN) {
            this.bxQ.put(str, str2);
        } else if (i == bxO) {
            if (this.bxR != null) {
                this.bxR.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == bxM) {
            str2 = this.bxP.get(str);
        } else if (i == bxN) {
            str2 = this.bxQ.get(str);
        } else if (i == bxO) {
            if (this.bxR != null) {
                str2 = this.bxR.getString(str, "");
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
        this.bxP.clear();
    }
}
