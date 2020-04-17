package com.baidu.swan.apps.aj.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aj.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a cpr;
    private c.a cps;
    private HashMap<String, c.a> cpt = new HashMap<>();

    public void ms(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        eM(true);
        E(str, true);
    }

    public ArrayList<String> eM(boolean z) {
        if (this.cps != null && this.cps.data != null && this.cps.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.cps.token + ", data=" + this.cps.data);
            }
            return this.cps.data;
        }
        if (this.cps != null) {
            this.cps.token = "";
            this.cps.data.clear();
        } else {
            this.cps = new c.a();
        }
        c.a(z, this.cps);
        return this.cps.data;
    }

    public ArrayList<String> alN() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> E(String str, boolean z) {
        if (this.cpr != null && this.cpr.data != null && this.cpr.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.cpr.token + ", data=" + this.cpr.data);
            }
            return this.cpr.data;
        }
        if (this.cpr != null) {
            this.cpr.token = "";
            this.cpr.data.clear();
        } else {
            this.cpr = new c.a();
        }
        c.a(z, str, this.cpr);
        return this.cpr.data;
    }

    public c.a k(String str, String str2, boolean z) {
        c.a aVar = this.cpt.get(str2);
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
            this.cpt.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.cpr != null) {
            this.cpr.data.clear();
        }
        if (this.cps != null) {
            this.cps.data.clear();
        }
        this.cpr = null;
        this.cps = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
