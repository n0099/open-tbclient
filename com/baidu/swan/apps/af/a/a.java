package com.baidu.swan.apps.af.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.af.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a bkO;
    private c.a bkP;
    private HashMap<String, c.a> bkQ = new HashMap<>();

    public void hy(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        cL(true);
        x(str, true);
    }

    public ArrayList<String> cL(boolean z) {
        if (this.bkP != null && this.bkP.data != null && this.bkP.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.bkP.token + ", data=" + this.bkP.data);
            }
            return this.bkP.data;
        }
        if (this.bkP != null) {
            this.bkP.token = "";
            this.bkP.data.clear();
        } else {
            this.bkP = new c.a();
        }
        c.a(z, this.bkP);
        return this.bkP.data;
    }

    public ArrayList<String> RI() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> x(String str, boolean z) {
        if (this.bkO != null && this.bkO.data != null && this.bkO.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.bkO.token + ", data=" + this.bkO.data);
            }
            return this.bkO.data;
        }
        if (this.bkO != null) {
            this.bkO.token = "";
            this.bkO.data.clear();
        } else {
            this.bkO = new c.a();
        }
        c.a(z, str, this.bkO);
        return this.bkO.data;
    }

    public c.a j(String str, String str2, boolean z) {
        c.a aVar = this.bkQ.get(str2);
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
            this.bkQ.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.bkO != null) {
            this.bkO.data.clear();
        }
        if (this.bkP != null) {
            this.bkP.data.clear();
        }
        this.bkO = null;
        this.bkP = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
