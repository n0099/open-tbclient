package com.baidu.swan.apps.ag.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ag.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a dgc;
    private c.a dgd;
    private HashMap<String, c.a> dge = new HashMap<>();

    public void rI(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        gi(true);
        aa(str, true);
    }

    public ArrayList<String> gi(boolean z) {
        if (this.dgd != null && this.dgd.data != null && this.dgd.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.dgd.token + ", data=" + this.dgd.data);
            }
            return this.dgd.data;
        }
        if (this.dgd != null) {
            this.dgd.token = "";
            this.dgd.data.clear();
        } else {
            this.dgd = new c.a();
        }
        c.a(z, this.dgd);
        return this.dgd.data;
    }

    public ArrayList<String> aEd() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> aa(String str, boolean z) {
        if (this.dgc != null && this.dgc.data != null && this.dgc.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.dgc.token + ", data=" + this.dgc.data);
            }
            return this.dgc.data;
        }
        if (this.dgc != null) {
            this.dgc.token = "";
            this.dgc.data.clear();
        } else {
            this.dgc = new c.a();
        }
        c.a(z, str, this.dgc);
        return this.dgc.data;
    }

    public c.a m(String str, String str2, boolean z) {
        c.a aVar = this.dge.get(str2);
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
            this.dge.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.dgc != null) {
            this.dgc.data.clear();
        }
        if (this.dgd != null) {
            this.dgd.data.clear();
        }
        this.dgc = null;
        this.dgd = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
