package com.baidu.swan.apps.af.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.af.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a dFO;
    private c.a dFP;
    private HashMap<String, c.a> dFQ = new HashMap<>();

    public void rW(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        hm(true);
        ac(str, true);
    }

    public ArrayList<String> hm(boolean z) {
        if (this.dFP != null && this.dFP.data != null && this.dFP.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.dFP.token + ", data=" + this.dFP.data);
            }
            return this.dFP.data;
        }
        if (this.dFP != null) {
            this.dFP.token = "";
            this.dFP.data.clear();
        } else {
            this.dFP = new c.a();
        }
        c.a(z, this.dFP);
        return this.dFP.data;
    }

    public ArrayList<String> aJN() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> ac(String str, boolean z) {
        if (this.dFO != null && this.dFO.data != null && this.dFO.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.dFO.token + ", data=" + this.dFO.data);
            }
            return this.dFO.data;
        }
        if (this.dFO != null) {
            this.dFO.token = "";
            this.dFO.data.clear();
        } else {
            this.dFO = new c.a();
        }
        c.a(z, str, this.dFO);
        return this.dFO.data;
    }

    public c.a q(String str, String str2, boolean z) {
        c.a aVar = this.dFQ.get(str2);
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
            this.dFQ.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.dFO != null) {
            this.dFO.data.clear();
        }
        if (this.dFP != null) {
            this.dFP.data.clear();
        }
        this.dFO = null;
        this.dFP = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
