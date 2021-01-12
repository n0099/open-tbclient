package com.baidu.swan.apps.af.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.af.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a dDK;
    private c.a dDL;
    private HashMap<String, c.a> dDM = new HashMap<>();

    public void rD(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        hk(true);
        ad(str, true);
    }

    public ArrayList<String> hk(boolean z) {
        if (this.dDL != null && this.dDL.data != null && this.dDL.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.dDL.token + ", data=" + this.dDL.data);
            }
            return this.dDL.data;
        }
        if (this.dDL != null) {
            this.dDL.token = "";
            this.dDL.data.clear();
        } else {
            this.dDL = new c.a();
        }
        c.a(z, this.dDL);
        return this.dDL.data;
    }

    public ArrayList<String> aJu() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> ad(String str, boolean z) {
        if (this.dDK != null && this.dDK.data != null && this.dDK.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.dDK.token + ", data=" + this.dDK.data);
            }
            return this.dDK.data;
        }
        if (this.dDK != null) {
            this.dDK.token = "";
            this.dDK.data.clear();
        } else {
            this.dDK = new c.a();
        }
        c.a(z, str, this.dDK);
        return this.dDK.data;
    }

    public c.a q(String str, String str2, boolean z) {
        c.a aVar = this.dDM.get(str2);
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
            this.dDM.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.dDK != null) {
            this.dDK.data.clear();
        }
        if (this.dDL != null) {
            this.dDL.data.clear();
        }
        this.dDK = null;
        this.dDL = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
