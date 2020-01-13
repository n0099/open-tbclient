package com.baidu.swan.apps.api.module.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.api.a.c {
    public c(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b eY(String str) {
        if (DEBUG) {
            Log.d("Api-NavigationBar", "set navigation bar title");
        }
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> ah = com.baidu.swan.apps.api.c.b.ah("Api-NavigationBar", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) ah.first;
        if (!bVar.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) ah.second;
        if (jSONObject == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "paramsJson is null");
            return new com.baidu.swan.apps.api.b.b(1001);
        }
        final String optString = jSONObject.optString("title");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "title is null");
            return new com.baidu.swan.apps.api.b.b(1001);
        }
        com.baidu.swan.apps.core.d.e El = com.baidu.swan.apps.y.f.UC().El();
        if (El == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "manager is null");
            return new com.baidu.swan.apps.api.b.b(1001);
        }
        final String optString2 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "callback is null");
            return new com.baidu.swan.apps.api.b.b(1001, "callback is null");
        }
        final com.baidu.swan.apps.core.d.b LX = El.LX();
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (!(LX != null && LX.gE(optString))) {
                    com.baidu.swan.apps.console.c.e("Api-NavigationBar", "set title fail");
                    c.this.a(optString2, new com.baidu.swan.apps.api.b.b(1001));
                }
                c.this.a(optString2, new com.baidu.swan.apps.api.b.b(0));
            }
        });
        return new com.baidu.swan.apps.api.b.b(0);
    }

    public com.baidu.swan.apps.api.b.b eZ(String str) {
        if (DEBUG) {
            Log.d("Api-NavigationBar", "set navigation bar color");
        }
        com.baidu.swan.apps.core.d.e El = com.baidu.swan.apps.y.f.UC().El();
        if (El == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "manager is null");
            return new com.baidu.swan.apps.api.b.b(1001);
        }
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> ah = com.baidu.swan.apps.api.c.b.ah("Api-NavigationBar", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) ah.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigationBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) ah.second;
        final String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Api-NavigationBar", "callback is null");
            return new com.baidu.swan.apps.api.b.b(1001, "callback is null");
        }
        final String optString2 = jSONObject.optString("frontColor");
        final String optString3 = jSONObject.optString("backgroundColor");
        final JSONObject optJSONObject = jSONObject.optJSONObject("animation");
        final com.baidu.swan.apps.core.d.b LX = El.LX();
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (LX == null || !LX.gF(optString2)) {
                    com.baidu.swan.apps.console.c.e("Api-NavigationBar", "set title color fail");
                    c.this.a(optString, new com.baidu.swan.apps.api.b.b(1001));
                } else if (!LX.ed(SwanAppConfigData.cy(optString3))) {
                    com.baidu.swan.apps.console.c.e("Api-NavigationBar", "set title background fail");
                    c.this.a(optString, new com.baidu.swan.apps.api.b.b(1001));
                } else {
                    if (optJSONObject != null) {
                        LX.v(optJSONObject.optInt("duration"), optJSONObject.optString("timingFunc"));
                        com.baidu.swan.apps.console.c.i("Api-NavigationBar", "set action bar animator");
                    }
                    c.this.a(optString, new com.baidu.swan.apps.api.b.b(0));
                }
            }
        });
        return new com.baidu.swan.apps.api.b.b(0);
    }
}
