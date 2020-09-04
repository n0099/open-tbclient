package com.baidu.swan.apps.ag.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ag.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a cRU;
    private c.a cRV;
    private HashMap<String, c.a> cRW = new HashMap<>();

    public void qD(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        fO(true);
        W(str, true);
    }

    public ArrayList<String> fO(boolean z) {
        if (this.cRV != null && this.cRV.data != null && this.cRV.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.cRV.token + ", data=" + this.cRV.data);
            }
            return this.cRV.data;
        }
        if (this.cRV != null) {
            this.cRV.token = "";
            this.cRV.data.clear();
        } else {
            this.cRV = new c.a();
        }
        c.a(z, this.cRV);
        return this.cRV.data;
    }

    public ArrayList<String> aAL() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> W(String str, boolean z) {
        if (this.cRU != null && this.cRU.data != null && this.cRU.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.cRU.token + ", data=" + this.cRU.data);
            }
            return this.cRU.data;
        }
        if (this.cRU != null) {
            this.cRU.token = "";
            this.cRU.data.clear();
        } else {
            this.cRU = new c.a();
        }
        c.a(z, str, this.cRU);
        return this.cRU.data;
    }

    public c.a m(String str, String str2, boolean z) {
        c.a aVar = this.cRW.get(str2);
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
            this.cRW.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.cRU != null) {
            this.cRU.data.clear();
        }
        if (this.cRV != null) {
            this.cRV.data.clear();
        }
        this.cRU = null;
        this.cRV = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
