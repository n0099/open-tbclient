package com.baidu.swan.apps.ah.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ah.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a cFY;
    private c.a cFZ;
    private HashMap<String, c.a> cGa = new HashMap<>();

    public void nX(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        fl(true);
        S(str, true);
    }

    public ArrayList<String> fl(boolean z) {
        if (this.cFZ != null && this.cFZ.data != null && this.cFZ.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.cFZ.token + ", data=" + this.cFZ.data);
            }
            return this.cFZ.data;
        }
        if (this.cFZ != null) {
            this.cFZ.token = "";
            this.cFZ.data.clear();
        } else {
            this.cFZ = new c.a();
        }
        c.a(z, this.cFZ);
        return this.cFZ.data;
    }

    public ArrayList<String> aqQ() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> S(String str, boolean z) {
        if (this.cFY != null && this.cFY.data != null && this.cFY.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.cFY.token + ", data=" + this.cFY.data);
            }
            return this.cFY.data;
        }
        if (this.cFY != null) {
            this.cFY.token = "";
            this.cFY.data.clear();
        } else {
            this.cFY = new c.a();
        }
        c.a(z, str, this.cFY);
        return this.cFY.data;
    }

    public c.a m(String str, String str2, boolean z) {
        c.a aVar = this.cGa.get(str2);
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
            this.cGa.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.cFY != null) {
            this.cFY.data.clear();
        }
        if (this.cFZ != null) {
            this.cFZ.data.clear();
        }
        this.cFY = null;
        this.cFZ = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
