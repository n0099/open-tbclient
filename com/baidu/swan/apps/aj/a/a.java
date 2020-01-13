package com.baidu.swan.apps.aj.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aj.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a bMn;
    private c.a bMo;
    private HashMap<String, c.a> bMp = new HashMap<>();

    public void kR(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        dI(true);
        z(str, true);
    }

    public ArrayList<String> dI(boolean z) {
        if (this.bMo != null && this.bMo.data != null && this.bMo.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.bMo.token + ", data=" + this.bMo.data);
            }
            return this.bMo.data;
        }
        if (this.bMo != null) {
            this.bMo.token = "";
            this.bMo.data.clear();
        } else {
            this.bMo = new c.a();
        }
        c.a(z, this.bMo);
        return this.bMo.data;
    }

    public ArrayList<String> abp() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> z(String str, boolean z) {
        if (this.bMn != null && this.bMn.data != null && this.bMn.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.bMn.token + ", data=" + this.bMn.data);
            }
            return this.bMn.data;
        }
        if (this.bMn != null) {
            this.bMn.token = "";
            this.bMn.data.clear();
        } else {
            this.bMn = new c.a();
        }
        c.a(z, str, this.bMn);
        return this.bMn.data;
    }

    public c.a k(String str, String str2, boolean z) {
        c.a aVar = this.bMp.get(str2);
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
            this.bMp.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.bMn != null) {
            this.bMn.data.clear();
        }
        if (this.bMo != null) {
            this.bMo.data.clear();
        }
        this.bMn = null;
        this.bMo = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
