package com.baidu.swan.apps.af.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.af.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private c.a aOL;
    private c.a aOM;
    private HashMap<String, c.a> aON = new HashMap<>();

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
        if (this.aOM != null && this.aOM.data != null && this.aOM.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.aOM.token + ", data=" + this.aOM.data);
            }
            return this.aOM.data;
        }
        if (this.aOM != null) {
            this.aOM.token = "";
            this.aOM.data.clear();
        } else {
            this.aOM = new c.a();
        }
        c.a(z, this.aOM);
        return this.aOM.data;
    }

    public ArrayList<String> JD() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> t(String str, boolean z) {
        if (this.aOL != null && this.aOL.data != null && this.aOL.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.aOL.token + ", data=" + this.aOL.data);
            }
            return this.aOL.data;
        }
        if (this.aOL != null) {
            this.aOL.token = "";
            this.aOL.data.clear();
        } else {
            this.aOL = new c.a();
        }
        c.a(z, str, this.aOL);
        return this.aOL.data;
    }

    public c.a g(String str, String str2, boolean z) {
        c.a aVar = this.aON.get(str2);
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
            this.aON.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.aOL != null) {
            this.aOL.data.clear();
        }
        if (this.aOM != null) {
            this.aOM.data.clear();
        }
        this.aOL = null;
        this.aOM = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
