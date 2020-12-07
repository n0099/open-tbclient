package com.baidu.swan.apps.ag.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ag.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes25.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a dzR;
    private c.a dzS;
    private HashMap<String, c.a> dzT = new HashMap<>();

    public void sS(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        gW(true);
        ad(str, true);
    }

    public ArrayList<String> gW(boolean z) {
        if (this.dzS != null && this.dzS.data != null && this.dzS.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.dzS.token + ", data=" + this.dzS.data);
            }
            return this.dzS.data;
        }
        if (this.dzS != null) {
            this.dzS.token = "";
            this.dzS.data.clear();
        } else {
            this.dzS = new c.a();
        }
        c.a(z, this.dzS);
        return this.dzS.data;
    }

    public ArrayList<String> aKX() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> ad(String str, boolean z) {
        if (this.dzR != null && this.dzR.data != null && this.dzR.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.dzR.token + ", data=" + this.dzR.data);
            }
            return this.dzR.data;
        }
        if (this.dzR != null) {
            this.dzR.token = "";
            this.dzR.data.clear();
        } else {
            this.dzR = new c.a();
        }
        c.a(z, str, this.dzR);
        return this.dzR.data;
    }

    public c.a o(String str, String str2, boolean z) {
        c.a aVar = this.dzT.get(str2);
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
            this.dzT.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.dzR != null) {
            this.dzR.data.clear();
        }
        if (this.dzS != null) {
            this.dzS.data.clear();
        }
        this.dzR = null;
        this.dzS = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
