package com.baidu.swan.apps.api.module.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class c extends com.baidu.swan.apps.api.a.d {
    public c(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lq(String str) {
        if (DEBUG) {
            Log.d("Api-NavigationBar", "set navigation bar title");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bp = com.baidu.swan.apps.api.d.b.bp("Api-NavigationBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bp.first;
        if (!bVar.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bp.second;
        if (jSONObject == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "paramsJson is null");
            return new com.baidu.swan.apps.api.c.b(1001);
        }
        final String optString = jSONObject.optString("title");
        com.baidu.swan.apps.core.d.f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001);
        }
        final String optString2 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        final com.baidu.swan.apps.core.d.c arB = aim.arB();
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.c.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z = true;
                if (arB == null || !arB.Q(optString, true)) {
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

    public com.baidu.swan.apps.api.c.b lr(String str) {
        if (DEBUG) {
            Log.d("Api-NavigationBar", "set navigation bar color");
        }
        com.baidu.swan.apps.core.d.f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bp = com.baidu.swan.apps.api.d.b.bp("Api-NavigationBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bp.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigationBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bp.second;
        final String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        final String optString2 = jSONObject.optString("frontColor");
        final String optString3 = jSONObject.optString("backgroundColor");
        final JSONObject optJSONObject = jSONObject.optJSONObject("animation");
        final com.baidu.swan.apps.core.d.c arB = aim.arB();
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (arB == null || !arB.R(optString2, true)) {
                    com.baidu.swan.apps.console.c.e("Api-NavigationBar", "set title color fail");
                    c.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                } else if (!arB.x(SwanAppConfigData.sI(optString3), true)) {
                    com.baidu.swan.apps.console.c.e("Api-NavigationBar", "set title background fail");
                    c.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                } else {
                    if (optJSONObject != null) {
                        arB.ai(optJSONObject.optInt("duration"), optJSONObject.optString("timingFunc"));
                        com.baidu.swan.apps.console.c.i("Api-NavigationBar", "set action bar animator");
                    }
                    c.this.a(optString, new com.baidu.swan.apps.api.c.b(0));
                }
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    public com.baidu.swan.apps.api.c.b ls(String str) {
        if (DEBUG) {
            Log.d("Api-NavigationBar", "start hide navigation bar loading");
        }
        return N(str, false);
    }

    public com.baidu.swan.apps.api.c.b lt(String str) {
        if (DEBUG) {
            Log.d("Api-NavigationBar", "start show navigation bar loading");
        }
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        if (aJV == null || !aJV.ama()) {
            return N(str, true);
        }
        if (DEBUG) {
            Log.d("Api-NavigationBar", "Api-NavigationBar does not supported when app is invisible.");
        }
        return new com.baidu.swan.apps.api.c.b(1001, "ui operation does not supported when app is invisible.");
    }

    private com.baidu.swan.apps.api.c.b N(String str, final boolean z) {
        com.baidu.swan.apps.core.d.f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bp = com.baidu.swan.apps.api.d.b.bp("Api-NavigationBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bp.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigationBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        final String optString = ((JSONObject) bp.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        final com.baidu.swan.apps.core.d.c arB = aim.arB();
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.c.3
            @Override // java.lang.Runnable
            public void run() {
                boolean aqX;
                if (arB == null) {
                    com.baidu.swan.apps.console.c.e("Api-NavigationBar", "swanAppFragment is null");
                    c.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                if (z) {
                    aqX = arB.aqW();
                } else {
                    aqX = arB.aqX();
                }
                if (!aqX) {
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
