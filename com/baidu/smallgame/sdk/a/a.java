package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class a {
    private static int aTO = 1;
    private static int aTP = 2;
    private static int aTQ = 3;
    private Map<String, String> aTR = new HashMap();
    private Map<String, String> aTS = new HashMap();
    private SharedPreferences aTT;

    public void b(SharedPreferences sharedPreferences) {
        this.aTT = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == aTO) {
            this.aTR.put(str, str2);
        } else if (i == aTP) {
            this.aTS.put(str, str2);
        } else if (i == aTQ) {
            if (this.aTT != null) {
                this.aTT.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == aTO) {
            str2 = this.aTR.get(str);
        } else if (i == aTP) {
            str2 = this.aTS.get(str);
        } else if (i == aTQ) {
            if (this.aTT != null) {
                str2 = this.aTT.getString(str, "");
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
        this.aTR.clear();
    }
}
