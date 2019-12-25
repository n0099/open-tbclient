package com.baidu.swan.apps.aj.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aj.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a bLD;
    private c.a bLE;
    private HashMap<String, c.a> bLF = new HashMap<>();

    public void kO(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        dD(true);
        z(str, true);
    }

    public ArrayList<String> dD(boolean z) {
        if (this.bLE != null && this.bLE.data != null && this.bLE.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.bLE.token + ", data=" + this.bLE.data);
            }
            return this.bLE.data;
        }
        if (this.bLE != null) {
            this.bLE.token = "";
            this.bLE.data.clear();
        } else {
            this.bLE = new c.a();
        }
        c.a(z, this.bLE);
        return this.bLE.data;
    }

    public ArrayList<String> aaS() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> z(String str, boolean z) {
        if (this.bLD != null && this.bLD.data != null && this.bLD.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.bLD.token + ", data=" + this.bLD.data);
            }
            return this.bLD.data;
        }
        if (this.bLD != null) {
            this.bLD.token = "";
            this.bLD.data.clear();
        } else {
            this.bLD = new c.a();
        }
        c.a(z, str, this.bLD);
        return this.bLD.data;
    }

    public c.a k(String str, String str2, boolean z) {
        c.a aVar = this.bLF.get(str2);
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
            this.bLF.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.bLD != null) {
            this.bLD.data.clear();
        }
        if (this.bLE != null) {
            this.bLE.data.clear();
        }
        this.bLD = null;
        this.bLE = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
