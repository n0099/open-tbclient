package com.baidu.swan.apps.aj.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aj.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a bQF;
    private c.a bQG;
    private HashMap<String, c.a> bQH = new HashMap<>();

    public void lf(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        dQ(true);
        z(str, true);
    }

    public ArrayList<String> dQ(boolean z) {
        if (this.bQG != null && this.bQG.data != null && this.bQG.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.bQG.token + ", data=" + this.bQG.data);
            }
            return this.bQG.data;
        }
        if (this.bQG != null) {
            this.bQG.token = "";
            this.bQG.data.clear();
        } else {
            this.bQG = new c.a();
        }
        c.a(z, this.bQG);
        return this.bQG.data;
    }

    public ArrayList<String> adI() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> z(String str, boolean z) {
        if (this.bQF != null && this.bQF.data != null && this.bQF.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.bQF.token + ", data=" + this.bQF.data);
            }
            return this.bQF.data;
        }
        if (this.bQF != null) {
            this.bQF.token = "";
            this.bQF.data.clear();
        } else {
            this.bQF = new c.a();
        }
        c.a(z, str, this.bQF);
        return this.bQF.data;
    }

    public c.a l(String str, String str2, boolean z) {
        c.a aVar = this.bQH.get(str2);
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
            this.bQH.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.bQF != null) {
            this.bQF.data.clear();
        }
        if (this.bQG != null) {
            this.bQG.data.clear();
        }
        this.bQF = null;
        this.bQG = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
