package com.baidu.swan.apps.ag.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ag.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a duA;
    private HashMap<String, c.a> duB = new HashMap<>();
    private c.a duz;

    public void sp(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        gE(true);
        ac(str, true);
    }

    public ArrayList<String> gE(boolean z) {
        if (this.duA != null && this.duA.data != null && this.duA.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.duA.token + ", data=" + this.duA.data);
            }
            return this.duA.data;
        }
        if (this.duA != null) {
            this.duA.token = "";
            this.duA.data.clear();
        } else {
            this.duA = new c.a();
        }
        c.a(z, this.duA);
        return this.duA.data;
    }

    public ArrayList<String> aIx() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> ac(String str, boolean z) {
        if (this.duz != null && this.duz.data != null && this.duz.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.duz.token + ", data=" + this.duz.data);
            }
            return this.duz.data;
        }
        if (this.duz != null) {
            this.duz.token = "";
            this.duz.data.clear();
        } else {
            this.duz = new c.a();
        }
        c.a(z, str, this.duz);
        return this.duz.data;
    }

    public c.a n(String str, String str2, boolean z) {
        c.a aVar = this.duB.get(str2);
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
            this.duB.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.duz != null) {
            this.duz.data.clear();
        }
        if (this.duA != null) {
            this.duA.data.clear();
        }
        this.duz = null;
        this.duA = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
