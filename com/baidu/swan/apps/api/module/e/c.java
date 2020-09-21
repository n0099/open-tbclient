package com.baidu.swan.apps.api.module.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends com.baidu.swan.apps.api.a.d {
    public c(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b jv(String str) {
        if (DEBUG) {
            Log.d("Api-NavigationBar", "set navigation bar title");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aX = com.baidu.swan.apps.api.d.b.aX("Api-NavigationBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aX.first;
        if (!bVar.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aX.second;
        if (jSONObject == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "paramsJson is null");
            return new com.baidu.swan.apps.api.c.b(1001);
        }
        final String optString = jSONObject.optString("title");
        com.baidu.swan.apps.core.d.f YG = com.baidu.swan.apps.v.f.asJ().YG();
        if (YG == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001);
        }
        final String optString2 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        final com.baidu.swan.apps.core.d.c ahW = YG.ahW();
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.c.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z = true;
                if (ahW == null || !ahW.J(optString, true)) {
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

    public com.baidu.swan.apps.api.c.b jw(String str) {
        if (DEBUG) {
            Log.d("Api-NavigationBar", "set navigation bar color");
        }
        com.baidu.swan.apps.core.d.f YG = com.baidu.swan.apps.v.f.asJ().YG();
        if (YG == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aX = com.baidu.swan.apps.api.d.b.aX("Api-NavigationBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aX.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigationBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aX.second;
        final String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        final String optString2 = jSONObject.optString("frontColor");
        final String optString3 = jSONObject.optString("backgroundColor");
        final JSONObject optJSONObject = jSONObject.optJSONObject("animation");
        final com.baidu.swan.apps.core.d.c ahW = YG.ahW();
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (ahW == null || !ahW.K(optString2, true)) {
                    com.baidu.swan.apps.console.c.e("Api-NavigationBar", "set title color fail");
                    c.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                } else if (!ahW.v(SwanAppConfigData.fq(optString3), true)) {
                    com.baidu.swan.apps.console.c.e("Api-NavigationBar", "set title background fail");
                    c.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                } else {
                    if (optJSONObject != null) {
                        ahW.R(optJSONObject.optInt("duration"), optJSONObject.optString("timingFunc"));
                        com.baidu.swan.apps.console.c.i("Api-NavigationBar", "set action bar animator");
                    }
                    c.this.a(optString, new com.baidu.swan.apps.api.c.b(0));
                }
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    public com.baidu.swan.apps.api.c.b jx(String str) {
        if (DEBUG) {
            Log.d("Api-NavigationBar", "start hide navigation bar loading");
        }
        return G(str, false);
    }

    public com.baidu.swan.apps.api.c.b jy(String str) {
        if (DEBUG) {
            Log.d("Api-NavigationBar", "start show navigation bar loading");
        }
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        if (aAs == null || !aAs.acu()) {
            return G(str, true);
        }
        if (DEBUG) {
            Log.d("Api-NavigationBar", "Api-NavigationBar does not supported when app is invisible.");
        }
        return new com.baidu.swan.apps.api.c.b(1001, "ui operation does not supported when app is invisible.");
    }

    private com.baidu.swan.apps.api.c.b G(String str, final boolean z) {
        com.baidu.swan.apps.core.d.f YG = com.baidu.swan.apps.v.f.asJ().YG();
        if (YG == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aX = com.baidu.swan.apps.api.d.b.aX("Api-NavigationBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aX.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigationBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        final String optString = ((JSONObject) aX.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        final com.baidu.swan.apps.core.d.c ahW = YG.ahW();
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.c.3
            @Override // java.lang.Runnable
            public void run() {
                boolean ahs;
                if (ahW == null) {
                    com.baidu.swan.apps.console.c.e("Api-NavigationBar", "swanAppFragment is null");
                    c.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                if (z) {
                    ahs = ahW.ahr();
                } else {
                    ahs = ahW.ahs();
                }
                if (!ahs) {
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
