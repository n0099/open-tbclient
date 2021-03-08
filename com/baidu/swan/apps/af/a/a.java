package com.baidu.swan.apps.af.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.af.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a dHp;
    private c.a dHq;
    private HashMap<String, c.a> dHr = new HashMap<>();

    public void sd(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        hm(true);
        ac(str, true);
    }

    public ArrayList<String> hm(boolean z) {
        if (this.dHq != null && this.dHq.data != null && this.dHq.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.dHq.token + ", data=" + this.dHq.data);
            }
            return this.dHq.data;
        }
        if (this.dHq != null) {
            this.dHq.token = "";
            this.dHq.data.clear();
        } else {
            this.dHq = new c.a();
        }
        c.a(z, this.dHq);
        return this.dHq.data;
    }

    public ArrayList<String> aJQ() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> ac(String str, boolean z) {
        if (this.dHp != null && this.dHp.data != null && this.dHp.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.dHp.token + ", data=" + this.dHp.data);
            }
            return this.dHp.data;
        }
        if (this.dHp != null) {
            this.dHp.token = "";
            this.dHp.data.clear();
        } else {
            this.dHp = new c.a();
        }
        c.a(z, str, this.dHp);
        return this.dHp.data;
    }

    public c.a q(String str, String str2, boolean z) {
        c.a aVar = this.dHr.get(str2);
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
            this.dHr.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.dHp != null) {
            this.dHp.data.clear();
        }
        if (this.dHq != null) {
            this.dHq.data.clear();
        }
        this.dHp = null;
        this.dHq = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
