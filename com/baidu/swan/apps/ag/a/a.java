package com.baidu.swan.apps.ag.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ag.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a doE;
    private c.a doF;
    private HashMap<String, c.a> doG = new HashMap<>();

    public void sb(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        gv(true);
        ac(str, true);
    }

    public ArrayList<String> gv(boolean z) {
        if (this.doF != null && this.doF.data != null && this.doF.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.doF.token + ", data=" + this.doF.data);
            }
            return this.doF.data;
        }
        if (this.doF != null) {
            this.doF.token = "";
            this.doF.data.clear();
        } else {
            this.doF = new c.a();
        }
        c.a(z, this.doF);
        return this.doF.data;
    }

    public ArrayList<String> aFX() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> ac(String str, boolean z) {
        if (this.doE != null && this.doE.data != null && this.doE.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.doE.token + ", data=" + this.doE.data);
            }
            return this.doE.data;
        }
        if (this.doE != null) {
            this.doE.token = "";
            this.doE.data.clear();
        } else {
            this.doE = new c.a();
        }
        c.a(z, str, this.doE);
        return this.doE.data;
    }

    public c.a m(String str, String str2, boolean z) {
        c.a aVar = this.doG.get(str2);
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
            this.doG.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.doE != null) {
            this.doE.data.clear();
        }
        if (this.doF != null) {
            this.doF.data.clear();
        }
        this.doE = null;
        this.doF = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
