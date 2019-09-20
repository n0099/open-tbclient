package com.baidu.swan.apps.af.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.af.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a aSc;
    private c.a aSd;
    private HashMap<String, c.a> aSe = new HashMap<>();

    public void gU(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        cu(true);
        u(str, true);
    }

    public ArrayList<String> cu(boolean z) {
        if (this.aSd != null && this.aSd.data != null && this.aSd.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.aSd.token + ", data=" + this.aSd.data);
            }
            return this.aSd.data;
        }
        if (this.aSd != null) {
            this.aSd.token = "";
            this.aSd.data.clear();
        } else {
            this.aSd = new c.a();
        }
        c.a(z, this.aSd);
        return this.aSd.data;
    }

    public ArrayList<String> MO() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> u(String str, boolean z) {
        if (this.aSc != null && this.aSc.data != null && this.aSc.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.aSc.token + ", data=" + this.aSc.data);
            }
            return this.aSc.data;
        }
        if (this.aSc != null) {
            this.aSc.token = "";
            this.aSc.data.clear();
        } else {
            this.aSc = new c.a();
        }
        c.a(z, str, this.aSc);
        return this.aSc.data;
    }

    public c.a g(String str, String str2, boolean z) {
        c.a aVar = this.aSe.get(str2);
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
            this.aSe.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.aSc != null) {
            this.aSc.data.clear();
        }
        if (this.aSd != null) {
            this.aSd.data.clear();
        }
        this.aSc = null;
        this.aSd = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
