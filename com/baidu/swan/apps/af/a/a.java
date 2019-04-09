package com.baidu.swan.apps.af.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.af.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a aOQ;
    private c.a aOR;
    private HashMap<String, c.a> aOS = new HashMap<>();

    public void gr(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        ce(true);
        t(str, true);
    }

    public ArrayList<String> ce(boolean z) {
        if (this.aOR != null && this.aOR.data != null && this.aOR.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.aOR.token + ", data=" + this.aOR.data);
            }
            return this.aOR.data;
        }
        if (this.aOR != null) {
            this.aOR.token = "";
            this.aOR.data.clear();
        } else {
            this.aOR = new c.a();
        }
        c.a(z, this.aOR);
        return this.aOR.data;
    }

    public ArrayList<String> JB() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> t(String str, boolean z) {
        if (this.aOQ != null && this.aOQ.data != null && this.aOQ.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.aOQ.token + ", data=" + this.aOQ.data);
            }
            return this.aOQ.data;
        }
        if (this.aOQ != null) {
            this.aOQ.token = "";
            this.aOQ.data.clear();
        } else {
            this.aOQ = new c.a();
        }
        c.a(z, str, this.aOQ);
        return this.aOQ.data;
    }

    public c.a g(String str, String str2, boolean z) {
        c.a aVar = this.aOS.get(str2);
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
            this.aOS.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.aOQ != null) {
            this.aOQ.data.clear();
        }
        if (this.aOR != null) {
            this.aOR.data.clear();
        }
        this.aOQ = null;
        this.aOR = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
