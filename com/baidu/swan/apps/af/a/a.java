package com.baidu.swan.apps.af.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.af.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a blg;
    private c.a blh;
    private HashMap<String, c.a> bli = new HashMap<>();

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
        if (this.blh != null && this.blh.data != null && this.blh.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.blh.token + ", data=" + this.blh.data);
            }
            return this.blh.data;
        }
        if (this.blh != null) {
            this.blh.token = "";
            this.blh.data.clear();
        } else {
            this.blh = new c.a();
        }
        c.a(z, this.blh);
        return this.blh.data;
    }

    public ArrayList<String> RG() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> x(String str, boolean z) {
        if (this.blg != null && this.blg.data != null && this.blg.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.blg.token + ", data=" + this.blg.data);
            }
            return this.blg.data;
        }
        if (this.blg != null) {
            this.blg.token = "";
            this.blg.data.clear();
        } else {
            this.blg = new c.a();
        }
        c.a(z, str, this.blg);
        return this.blg.data;
    }

    public c.a j(String str, String str2, boolean z) {
        c.a aVar = this.bli.get(str2);
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
            this.bli.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.blg != null) {
            this.blg.data.clear();
        }
        if (this.blh != null) {
            this.blh.data.clear();
        }
        this.blg = null;
        this.blh = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
