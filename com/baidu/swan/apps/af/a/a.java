package com.baidu.swan.apps.af.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.af.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a aRE;
    private c.a aRF;
    private HashMap<String, c.a> aRG = new HashMap<>();

    public void gS(String str) {
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
        if (this.aRF != null && this.aRF.data != null && this.aRF.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.aRF.token + ", data=" + this.aRF.data);
            }
            return this.aRF.data;
        }
        if (this.aRF != null) {
            this.aRF.token = "";
            this.aRF.data.clear();
        } else {
            this.aRF = new c.a();
        }
        c.a(z, this.aRF);
        return this.aRF.data;
    }

    public ArrayList<String> MK() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> u(String str, boolean z) {
        if (this.aRE != null && this.aRE.data != null && this.aRE.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.aRE.token + ", data=" + this.aRE.data);
            }
            return this.aRE.data;
        }
        if (this.aRE != null) {
            this.aRE.token = "";
            this.aRE.data.clear();
        } else {
            this.aRE = new c.a();
        }
        c.a(z, str, this.aRE);
        return this.aRE.data;
    }

    public c.a g(String str, String str2, boolean z) {
        c.a aVar = this.aRG.get(str2);
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
            this.aRG.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.aRE != null) {
            this.aRE.data.clear();
        }
        if (this.aRF != null) {
            this.aRF.data.clear();
        }
        this.aRE = null;
        this.aRF = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
