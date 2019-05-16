package com.baidu.swan.apps.af.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.af.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a aQU;
    private c.a aQV;
    private HashMap<String, c.a> aQW = new HashMap<>();

    public void gM(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        cr(true);
        t(str, true);
    }

    public ArrayList<String> cr(boolean z) {
        if (this.aQV != null && this.aQV.data != null && this.aQV.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.aQV.token + ", data=" + this.aQV.data);
            }
            return this.aQV.data;
        }
        if (this.aQV != null) {
            this.aQV.token = "";
            this.aQV.data.clear();
        } else {
            this.aQV = new c.a();
        }
        c.a(z, this.aQV);
        return this.aQV.data;
    }

    public ArrayList<String> LW() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> t(String str, boolean z) {
        if (this.aQU != null && this.aQU.data != null && this.aQU.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.aQU.token + ", data=" + this.aQU.data);
            }
            return this.aQU.data;
        }
        if (this.aQU != null) {
            this.aQU.token = "";
            this.aQU.data.clear();
        } else {
            this.aQU = new c.a();
        }
        c.a(z, str, this.aQU);
        return this.aQU.data;
    }

    public c.a g(String str, String str2, boolean z) {
        c.a aVar = this.aQW.get(str2);
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
            this.aQW.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.aQU != null) {
            this.aQU.data.clear();
        }
        if (this.aQV != null) {
            this.aQV.data.clear();
        }
        this.aQU = null;
        this.aQV = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
