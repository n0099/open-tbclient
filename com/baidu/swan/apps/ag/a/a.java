package com.baidu.swan.apps.ag.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ag.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a cRQ;
    private c.a cRR;
    private HashMap<String, c.a> cRS = new HashMap<>();

    public void qC(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        fN(true);
        W(str, true);
    }

    public ArrayList<String> fN(boolean z) {
        if (this.cRR != null && this.cRR.data != null && this.cRR.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.cRR.token + ", data=" + this.cRR.data);
            }
            return this.cRR.data;
        }
        if (this.cRR != null) {
            this.cRR.token = "";
            this.cRR.data.clear();
        } else {
            this.cRR = new c.a();
        }
        c.a(z, this.cRR);
        return this.cRR.data;
    }

    public ArrayList<String> aAL() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> W(String str, boolean z) {
        if (this.cRQ != null && this.cRQ.data != null && this.cRQ.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.cRQ.token + ", data=" + this.cRQ.data);
            }
            return this.cRQ.data;
        }
        if (this.cRQ != null) {
            this.cRQ.token = "";
            this.cRQ.data.clear();
        } else {
            this.cRQ = new c.a();
        }
        c.a(z, str, this.cRQ);
        return this.cRQ.data;
    }

    public c.a m(String str, String str2, boolean z) {
        c.a aVar = this.cRS.get(str2);
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
            this.cRS.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.cRQ != null) {
            this.cRQ.data.clear();
        }
        if (this.cRR != null) {
            this.cRR.data.clear();
        }
        this.cRQ = null;
        this.cRR = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
