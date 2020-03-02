package com.baidu.swan.apps.aj.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aj.a.c;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c.a bQt;
    private c.a bQu;
    private HashMap<String, c.a> bQv = new HashMap<>();

    public void lg(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new RuntimeException("appId can not be empty");
            }
            return;
        }
        dP(true);
        z(str, true);
    }

    public ArrayList<String> dP(boolean z) {
        if (this.bQu != null && this.bQu.data != null && this.bQu.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webActions from cache: token=" + this.bQu.token + ", data=" + this.bQu.data);
            }
            return this.bQu.data;
        }
        if (this.bQu != null) {
            this.bQu.token = "";
            this.bQu.data.clear();
        } else {
            this.bQu = new c.a();
        }
        c.a(z, this.bQu);
        return this.bQu.data;
    }

    public ArrayList<String> adF() {
        c.a aVar = new c.a();
        c.a(aVar);
        return aVar.data;
    }

    public ArrayList<String> z(String str, boolean z) {
        if (this.bQt != null && this.bQt.data != null && this.bQt.data.size() > 0) {
            if (DEBUG) {
                Log.e("SwanAppWebSafe", "read webdomains from cache: token=" + this.bQt.token + ", data=" + this.bQt.data);
            }
            return this.bQt.data;
        }
        if (this.bQt != null) {
            this.bQt.token = "";
            this.bQt.data.clear();
        } else {
            this.bQt = new c.a();
        }
        c.a(z, str, this.bQt);
        return this.bQt.data;
    }

    public c.a l(String str, String str2, boolean z) {
        c.a aVar = this.bQv.get(str2);
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
            this.bQv.put(str2, aVar);
        }
        return aVar;
    }

    public void release() {
        if (this.bQt != null) {
            this.bQt.data.clear();
        }
        if (this.bQu != null) {
            this.bQu.data.clear();
        }
        this.bQt = null;
        this.bQu = null;
        if (DEBUG) {
            Log.d("SwanAppWebSafe", "release cache done");
        }
    }
}
