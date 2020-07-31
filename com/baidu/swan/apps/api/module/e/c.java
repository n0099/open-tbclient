package com.baidu.swan.apps.api.module.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends com.baidu.swan.apps.api.a.d {
    public c(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b hE(String str) {
        if (DEBUG) {
            Log.d("Api-NavigationBar", "set navigation bar title");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aS = com.baidu.swan.apps.api.d.b.aS("Api-NavigationBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aS.first;
        if (!bVar.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aS.second;
        if (jSONObject == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "paramsJson is null");
            return new com.baidu.swan.apps.api.c.b(1001);
        }
        final String optString = jSONObject.optString("title");
        com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001);
        }
        final String optString2 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        final com.baidu.swan.apps.core.d.c aaZ = Sc.aaZ();
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.c.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z = true;
                if (aaZ == null || !aaZ.F(optString, true)) {
                    z = false;
                }
                if (!z) {
                    com.baidu.swan.apps.console.c.e("Api-NavigationBar", "set title fail");
                    c.this.a(optString2, new com.baidu.swan.apps.api.c.b(1001));
                }
                c.this.a(optString2, new com.baidu.swan.apps.api.c.b(0));
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    public com.baidu.swan.apps.api.c.b hF(String str) {
        if (DEBUG) {
            Log.d("Api-NavigationBar", "set navigation bar color");
        }
        com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aS = com.baidu.swan.apps.api.d.b.aS("Api-NavigationBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aS.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigationBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aS.second;
        final String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        final String optString2 = jSONObject.optString("frontColor");
        final String optString3 = jSONObject.optString("backgroundColor");
        final JSONObject optJSONObject = jSONObject.optJSONObject("animation");
        final com.baidu.swan.apps.core.d.c aaZ = Sc.aaZ();
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (aaZ == null || !aaZ.G(optString2, true)) {
                    com.baidu.swan.apps.console.c.e("Api-NavigationBar", "set title color fail");
                    c.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                } else if (!aaZ.t(SwanAppConfigData.dU(optString3), true)) {
                    com.baidu.swan.apps.console.c.e("Api-NavigationBar", "set title background fail");
                    c.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                } else {
                    if (optJSONObject != null) {
                        aaZ.R(optJSONObject.optInt("duration"), optJSONObject.optString("timingFunc"));
                        com.baidu.swan.apps.console.c.i("Api-NavigationBar", "set action bar animator");
                    }
                    c.this.a(optString, new com.baidu.swan.apps.api.c.b(0));
                }
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    public com.baidu.swan.apps.api.c.b hG(String str) {
        if (DEBUG) {
            Log.d("Api-NavigationBar", "start hide navigation bar loading");
        }
        return B(str, false);
    }

    public com.baidu.swan.apps.api.c.b hH(String str) {
        if (DEBUG) {
            Log.d("Api-NavigationBar", "start show navigation bar loading");
        }
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        if (arw == null || !arw.VF()) {
            return B(str, true);
        }
        if (DEBUG) {
            Log.d("Api-NavigationBar", "Api-NavigationBar does not supported when app is invisible.");
        }
        return new com.baidu.swan.apps.api.c.b(1001, "ui operation does not supported when app is invisible.");
    }

    private com.baidu.swan.apps.api.c.b B(String str, final boolean z) {
        com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aS = com.baidu.swan.apps.api.d.b.aS("Api-NavigationBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aS.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigationBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        final String optString = ((JSONObject) aS.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        final com.baidu.swan.apps.core.d.c aaZ = Sc.aaZ();
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.c.3
            @Override // java.lang.Runnable
            public void run() {
                boolean aay;
                if (aaZ == null) {
                    com.baidu.swan.apps.console.c.e("Api-NavigationBar", "swanAppFragment is null");
                    c.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                if (z) {
                    aay = aaZ.aax();
                } else {
                    aay = aaZ.aay();
                }
                if (!aay) {
                    com.baidu.swan.apps.console.c.e("Api-NavigationBar", (z ? "show" : "hide") + " navigation loading progressbar fail");
                    c.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                c.this.a(optString, new com.baidu.swan.apps.api.c.b(0));
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }
}
