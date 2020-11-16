package com.baidu.swan.apps.ag.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ag.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a dsR;
    private c.a dsS;
    private HashMap<String, c.a> dsT = new HashMap<>();

    public void sk(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        gH(true);
        ac(str, true);
    }

    public ArrayList<String> gH(boolean z) {
        if (this.dsS != null && this.dsS.data != null && this.dsS.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.dsS.token + ", data=" + this.dsS.data);
            }
            return this.dsS.data;
        }
        if (this.dsS != null) {
            this.dsS.token = "";
            this.dsS.data.clear();
        } else {
            this.dsS = new c.a();
        }
        c.a(z, this.dsS);
        return this.dsS.data;
    }

    public ArrayList<String> aHP() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> ac(String str, boolean z) {
        if (this.dsR != null && this.dsR.data != null && this.dsR.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.dsR.token + ", data=" + this.dsR.data);
            }
            return this.dsR.data;
        }
        if (this.dsR != null) {
            this.dsR.token = "";
            this.dsR.data.clear();
        } else {
            this.dsR = new c.a();
        }
        c.a(z, str, this.dsR);
        return this.dsR.data;
    }

    public c.a n(String str, String str2, boolean z) {
        c.a aVar = this.dsT.get(str2);
        if (aVar != null && aVar.data != null && aVar.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read serverDomains from cache: data= " + aVar.data);
            }
        } else {
            if (aVar != null) {
                aVar.data.clear();
                aVar.token = "";
            } else {
                aVar = new c.a();
            }
            c.a(z, str, str2, aVar);
            this.dsT.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.dsR != null) {
            this.dsR.data.clear();
        }
        if (this.dsS != null) {
            this.dsS.data.clear();
        }
        this.dsR = null;
        this.dsS = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
