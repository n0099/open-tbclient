package com.baidu.swan.apps.af.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.af.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a aOM;
    private c.a aON;
    private HashMap<String, c.a> aOO = new HashMap<>();

    public void gq(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        ce(true);
        t(str, true);
    }

    public ArrayList<String> ce(boolean z) {
        if (this.aON != null && this.aON.data != null && this.aON.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.aON.token + ", data=" + this.aON.data);
            }
            return this.aON.data;
        }
        if (this.aON != null) {
            this.aON.token = "";
            this.aON.data.clear();
        } else {
            this.aON = new c.a();
        }
        c.a(z, this.aON);
        return this.aON.data;
    }

    public ArrayList<String> JD() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> t(String str, boolean z) {
        if (this.aOM != null && this.aOM.data != null && this.aOM.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.aOM.token + ", data=" + this.aOM.data);
            }
            return this.aOM.data;
        }
        if (this.aOM != null) {
            this.aOM.token = "";
            this.aOM.data.clear();
        } else {
            this.aOM = new c.a();
        }
        c.a(z, str, this.aOM);
        return this.aOM.data;
    }

    public c.a g(String str, String str2, boolean z) {
        c.a aVar = this.aOO.get(str2);
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
            this.aOO.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.aOM != null) {
            this.aOM.data.clear();
        }
        if (this.aON != null) {
            this.aON.data.clear();
        }
        this.aOM = null;
        this.aON = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
