package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class a {
    private static int cmN = 1;
    private static int cmO = 2;
    private static int cmP = 3;
    private Map<String, String> cmQ = new HashMap();
    private Map<String, String> cmR = new HashMap();
    private SharedPreferences cmS;

    public void b(SharedPreferences sharedPreferences) {
        this.cmS = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == cmN) {
            this.cmQ.put(str, str2);
        } else if (i == cmO) {
            this.cmR.put(str, str2);
        } else if (i == cmP) {
            if (this.cmS != null) {
                this.cmS.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == cmN) {
            str2 = this.cmQ.get(str);
        } else if (i == cmO) {
            str2 = this.cmR.get(str);
        } else if (i == cmP) {
            if (this.cmS != null) {
                str2 = this.cmS.getString(str, "");
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
        this.cmQ.clear();
    }
}
