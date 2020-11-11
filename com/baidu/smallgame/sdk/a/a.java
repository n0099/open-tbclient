package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class a {
    private static int csK = 1;
    private static int csL = 2;
    private static int csM = 3;
    private Map<String, String> csN = new HashMap();
    private Map<String, String> csO = new HashMap();
    private SharedPreferences csP;

    public void b(SharedPreferences sharedPreferences) {
        this.csP = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == csK) {
            this.csN.put(str, str2);
        } else if (i == csL) {
            this.csO.put(str, str2);
        } else if (i == csM) {
            if (this.csP != null) {
                this.csP.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == csK) {
            str2 = this.csN.get(str);
        } else if (i == csL) {
            str2 = this.csO.get(str);
        } else if (i == csM) {
            if (this.csP != null) {
                str2 = this.csP.getString(str, "");
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
        this.csN.clear();
    }
}
