package com.baidu.swan.apps.aj.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aj.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private HashMap<String, c.a> cpA = new HashMap<>();
    private c.a cpy;
    private c.a cpz;

    public void ms(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        eM(true);
        E(str, true);
    }

    public ArrayList<String> eM(boolean z) {
        if (this.cpz != null && this.cpz.data != null && this.cpz.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.cpz.token + ", data=" + this.cpz.data);
            }
            return this.cpz.data;
        }
        if (this.cpz != null) {
            this.cpz.token = "";
            this.cpz.data.clear();
        } else {
            this.cpz = new c.a();
        }
        c.a(z, this.cpz);
        return this.cpz.data;
    }

    public ArrayList<String> alM() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> E(String str, boolean z) {
        if (this.cpy != null && this.cpy.data != null && this.cpy.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.cpy.token + ", data=" + this.cpy.data);
            }
            return this.cpy.data;
        }
        if (this.cpy != null) {
            this.cpy.token = "";
            this.cpy.data.clear();
        } else {
            this.cpy = new c.a();
        }
        c.a(z, str, this.cpy);
        return this.cpy.data;
    }

    public c.a k(String str, String str2, boolean z) {
        c.a aVar = this.cpA.get(str2);
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
            this.cpA.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.cpy != null) {
            this.cpy.data.clear();
        }
        if (this.cpz != null) {
            this.cpz.data.clear();
        }
        this.cpy = null;
        this.cpz = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
