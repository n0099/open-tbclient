package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static int aDN = 1;
    private static int aDO = 2;
    private static int aDP = 3;
    private Map<String, String> aDQ = new HashMap();
    private Map<String, String> aDR = new HashMap();
    private SharedPreferences aDS;

    public void b(SharedPreferences sharedPreferences) {
        this.aDS = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == aDN) {
            this.aDQ.put(str, str2);
        } else if (i == aDO) {
            this.aDR.put(str, str2);
        } else if (i == aDP) {
            if (this.aDS != null) {
                this.aDS.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == aDN) {
            str2 = this.aDQ.get(str);
        } else if (i == aDO) {
            str2 = this.aDR.get(str);
        } else if (i == aDP) {
            if (this.aDS != null) {
                str2 = this.aDS.getString(str, "");
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
        this.aDQ.clear();
    }
}
