package com.baidu.smallgame.sdk.a;

import android.content.SharedPreferences;
import com.baidu.smallgame.sdk.Log;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class a {
    private static int cep = 1;
    private static int ceq = 2;
    private static int cer = 3;
    private Map<String, String> ces = new HashMap();
    private Map<String, String> cet = new HashMap();
    private SharedPreferences ceu;

    public void b(SharedPreferences sharedPreferences) {
        this.ceu = sharedPreferences;
    }

    public void setValue(int i, String str, String str2) {
        if (i == cep) {
            this.ces.put(str, str2);
        } else if (i == ceq) {
            this.cet.put(str, str2);
        } else if (i == cer) {
            if (this.ceu != null) {
                this.ceu.edit().putString(str, str2).commit();
            } else {
                Log.e("TAG", "prefs data store is null");
            }
        }
    }

    public String getValue(int i, String str) {
        String str2 = null;
        if (i == cep) {
            str2 = this.ces.get(str);
        } else if (i == ceq) {
            str2 = this.cet.get(str);
        } else if (i == cer) {
            if (this.ceu != null) {
                str2 = this.ceu.getString(str, "");
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
        this.ces.clear();
    }
}
