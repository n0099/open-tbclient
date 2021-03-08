package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes14.dex */
public class a {
    private static int cBY = 1;
    private static int cBZ = 2;
    private static int cCa = 3;
    private Map<String, String> cCb = new HashMap();
    private Map<String, String> cCc = new HashMap();
    private SharedPreferences cCd;

    public void b(SharedPreferences sharedPreferences) {
        this.cCd = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == cBY) {
            this.cCb.put(str, str2);
        } else if (i == cBZ) {
            this.cCc.put(str, str2);
        } else if (i == cCa) {
            if (this.cCd != null) {
                this.cCd.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == cBY) {
            str2 = this.cCb.get(str);
        } else if (i == cBZ) {
            str2 = this.cCc.get(str);
        } else if (i == cCa) {
            if (this.cCd != null) {
                str2 = this.cCd.getString(str, "");
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
        this.cCb.clear();
    }
}
