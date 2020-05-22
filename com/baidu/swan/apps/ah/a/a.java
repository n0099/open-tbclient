package com.baidu.swan.apps.ah.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ah.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a cBo;
    private c.a cBp;
    private HashMap<String, c.a> cBq = new HashMap<>();

    public void nP(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        fg(true);
        Q(str, true);
    }

    public ArrayList<String> fg(boolean z) {
        if (this.cBp != null && this.cBp.data != null && this.cBp.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.cBp.token + ", data=" + this.cBp.data);
            }
            return this.cBp.data;
        }
        if (this.cBp != null) {
            this.cBp.token = "";
            this.cBp.data.clear();
        } else {
            this.cBp = new c.a();
        }
        c.a(z, this.cBp);
        return this.cBp.data;
    }

    public ArrayList<String> apK() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> Q(String str, boolean z) {
        if (this.cBo != null && this.cBo.data != null && this.cBo.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.cBo.token + ", data=" + this.cBo.data);
            }
            return this.cBo.data;
        }
        if (this.cBo != null) {
            this.cBo.token = "";
            this.cBo.data.clear();
        } else {
            this.cBo = new c.a();
        }
        c.a(z, str, this.cBo);
        return this.cBo.data;
    }

    public c.a m(String str, String str2, boolean z) {
        c.a aVar = this.cBq.get(str2);
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
            this.cBq.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.cBo != null) {
            this.cBo.data.clear();
        }
        if (this.cBp != null) {
            this.cBp.data.clear();
        }
        this.cBo = null;
        this.cBp = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
