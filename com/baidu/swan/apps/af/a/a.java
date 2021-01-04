package com.baidu.swan.apps.af.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.af.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a dIw;
    private c.a dIx;
    private HashMap<String, c.a> dIy = new HashMap<>();

    public void sP(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        ho(true);
        ad(str, true);
    }

    public ArrayList<String> ho(boolean z) {
        if (this.dIx != null && this.dIx.data != null && this.dIx.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.dIx.token + ", data=" + this.dIx.data);
            }
            return this.dIx.data;
        }
        if (this.dIx != null) {
            this.dIx.token = "";
            this.dIx.data.clear();
        } else {
            this.dIx = new c.a();
        }
        c.a(z, this.dIx);
        return this.dIx.data;
    }

    public ArrayList<String> aNn() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> ad(String str, boolean z) {
        if (this.dIw != null && this.dIw.data != null && this.dIw.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.dIw.token + ", data=" + this.dIw.data);
            }
            return this.dIw.data;
        }
        if (this.dIw != null) {
            this.dIw.token = "";
            this.dIw.data.clear();
        } else {
            this.dIw = new c.a();
        }
        c.a(z, str, this.dIw);
        return this.dIw.data;
    }

    public c.a q(String str, String str2, boolean z) {
        c.a aVar = this.dIy.get(str2);
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
            this.dIy.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.dIw != null) {
            this.dIw.data.clear();
        }
        if (this.dIx != null) {
            this.dIx.data.clear();
        }
        this.dIw = null;
        this.dIx = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
