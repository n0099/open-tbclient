package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class a {
    private static int cCO = 1;
    private static int cCP = 2;
    private static int cCQ = 3;
    private Map<String, String> cCR = new HashMap();
    private Map<String, String> cCS = new HashMap();
    private SharedPreferences cCT;

    public void b(SharedPreferences sharedPreferences) {
        this.cCT = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == cCO) {
            this.cCR.put(str, str2);
        } else if (i == cCP) {
            this.cCS.put(str, str2);
        } else if (i == cCQ) {
            if (this.cCT != null) {
                this.cCT.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == cCO) {
            str2 = this.cCR.get(str);
        } else if (i == cCP) {
            str2 = this.cCS.get(str);
        } else if (i == cCQ) {
            if (this.cCT != null) {
                str2 = this.cCT.getString(str, "");
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
        this.cCR.clear();
    }
}
