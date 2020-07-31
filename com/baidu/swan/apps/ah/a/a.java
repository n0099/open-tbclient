package com.baidu.swan.apps.ah.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ah.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a cIQ;
    private c.a cIR;
    private HashMap<String, c.a> cIS = new HashMap<>();

    public void oF(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        fu(true);
        R(str, true);
    }

    public ArrayList<String> fu(boolean z) {
        if (this.cIR != null && this.cIR.data != null && this.cIR.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.cIR.token + ", data=" + this.cIR.data);
            }
            return this.cIR.data;
        }
        if (this.cIR != null) {
            this.cIR.token = "";
            this.cIR.data.clear();
        } else {
            this.cIR = new c.a();
        }
        c.a(z, this.cIR);
        return this.cIR.data;
    }

    public ArrayList<String> asz() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> R(String str, boolean z) {
        if (this.cIQ != null && this.cIQ.data != null && this.cIQ.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.cIQ.token + ", data=" + this.cIQ.data);
            }
            return this.cIQ.data;
        }
        if (this.cIQ != null) {
            this.cIQ.token = "";
            this.cIQ.data.clear();
        } else {
            this.cIQ = new c.a();
        }
        c.a(z, str, this.cIQ);
        return this.cIQ.data;
    }

    public c.a m(String str, String str2, boolean z) {
        c.a aVar = this.cIS.get(str2);
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
            this.cIS.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.cIQ != null) {
            this.cIQ.data.clear();
        }
        if (this.cIR != null) {
            this.cIR.data.clear();
        }
        this.cIQ = null;
        this.cIR = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
