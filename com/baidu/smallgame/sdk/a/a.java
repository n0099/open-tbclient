package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private static int cqZ = 1;
    private static int cra = 2;
    private static int crb = 3;
    private Map<String, String> crd = new HashMap();
    private Map<String, String> cre = new HashMap();
    private SharedPreferences crf;

    public void b(SharedPreferences sharedPreferences) {
        this.crf = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == cqZ) {
            this.crd.put(str, str2);
        } else if (i == cra) {
            this.cre.put(str, str2);
        } else if (i == crb) {
            if (this.crf != null) {
                this.crf.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == cqZ) {
            str2 = this.crd.get(str);
        } else if (i == cra) {
            str2 = this.cre.get(str);
        } else if (i == crb) {
            if (this.crf != null) {
                str2 = this.crf.getString(str, "");
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
        this.crd.clear();
    }
}
