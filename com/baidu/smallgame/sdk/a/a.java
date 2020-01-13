package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class a {
    private static int aUG = 1;
    private static int aUH = 2;
    private static int aUI = 3;
    private Map<String, String> aUJ = new HashMap();
    private Map<String, String> aUK = new HashMap();
    private SharedPreferences aUL;

    public void b(SharedPreferences sharedPreferences) {
        this.aUL = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == aUG) {
            this.aUJ.put(str, str2);
        } else if (i == aUH) {
            this.aUK.put(str, str2);
        } else if (i == aUI) {
            if (this.aUL != null) {
                this.aUL.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == aUG) {
            str2 = this.aUJ.get(str);
        } else if (i == aUH) {
            str2 = this.aUK.get(str);
        } else if (i == aUI) {
            if (this.aUL != null) {
                str2 = this.aUL.getString(str, "");
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
        this.aUJ.clear();
    }
}
