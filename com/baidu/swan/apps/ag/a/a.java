package com.baidu.swan.apps.ag.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ag.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a cTU;
    private c.a cTV;
    private HashMap<String, c.a> cTW = new HashMap<>();

    public void qW(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        fM(true);
        W(str, true);
    }

    public ArrayList<String> fM(boolean z) {
        if (this.cTV != null && this.cTV.data != null && this.cTV.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.cTV.token + ", data=" + this.cTV.data);
            }
            return this.cTV.data;
        }
        if (this.cTV != null) {
            this.cTV.token = "";
            this.cTV.data.clear();
        } else {
            this.cTV = new c.a();
        }
        c.a(z, this.cTV);
        return this.cTV.data;
    }

    public ArrayList<String> aBu() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> W(String str, boolean z) {
        if (this.cTU != null && this.cTU.data != null && this.cTU.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.cTU.token + ", data=" + this.cTU.data);
            }
            return this.cTU.data;
        }
        if (this.cTU != null) {
            this.cTU.token = "";
            this.cTU.data.clear();
        } else {
            this.cTU = new c.a();
        }
        c.a(z, str, this.cTU);
        return this.cTU.data;
    }

    public c.a m(String str, String str2, boolean z) {
        c.a aVar = this.cTW.get(str2);
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
            this.cTW.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.cTU != null) {
            this.cTU.data.clear();
        }
        if (this.cTV != null) {
            this.cTV.data.clear();
        }
        this.cTU = null;
        this.cTV = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
