package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static int bFp = 1;
    private static int bFq = 2;
    private static int bFr = 3;
    private Map<String, String> bFs = new HashMap();
    private Map<String, String> bFt = new HashMap();
    private SharedPreferences bFu;

    public void b(SharedPreferences sharedPreferences) {
        this.bFu = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == bFp) {
            this.bFs.put(str, str2);
        } else if (i == bFq) {
            this.bFt.put(str, str2);
        } else if (i == bFr) {
            if (this.bFu != null) {
                this.bFu.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == bFp) {
            str2 = this.bFs.get(str);
        } else if (i == bFq) {
            str2 = this.bFt.get(str);
        } else if (i == bFr) {
            if (this.bFu != null) {
                str2 = this.bFu.getString(str, "");
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
        this.bFs.clear();
    }
}
