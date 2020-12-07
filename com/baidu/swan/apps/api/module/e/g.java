package com.baidu.swan.apps.api.module.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.ap.ak;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class g extends com.baidu.swan.apps.api.a.d {
    public g(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lB(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "handle: " + str);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bp = com.baidu.swan.apps.api.d.b.bp("Api-TabBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bp.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        int optInt = ((JSONObject) bp.second).optInt("index");
        if (amk()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.c.b(1001, "fail not TabBar page");
        }
        com.baidu.swan.apps.tabbar.b.a amj = amj();
        if (amj == null) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
            return new com.baidu.swan.apps.api.c.b(1001, "tabBarViewController is null");
        } else if (!amj.lD(optInt)) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "close red dot fail");
            return new com.baidu.swan.apps.api.c.b(1001, "close red dot fail");
        } else {
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    public com.baidu.swan.apps.api.c.b lC(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "handle: " + str);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bp = com.baidu.swan.apps.api.d.b.bp("Api-TabBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bp.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bp.second;
        if (amk()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.c.b(1001, "fail not TabBar page");
        }
        com.baidu.swan.apps.tabbar.b.a amj = amj();
        if (amj == null) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
            return new com.baidu.swan.apps.api.c.b(1001, "tabBarViewController is null");
        } else if (!amj.b(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "set tab bar item fail");
            return new com.baidu.swan.apps.api.c.b(1001, "set tab bar item fail");
        } else {
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    public static com.baidu.swan.apps.tabbar.b.a amj() {
        com.baidu.swan.apps.core.d.e arD;
        com.baidu.swan.apps.core.d.f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim == null || (arD = aim.arD()) == null) {
            return null;
        }
        return arD.aro();
    }

    public static boolean amk() {
        com.baidu.swan.apps.core.d.f aim = com.baidu.swan.apps.v.f.aCp().aim();
        return aim == null || aim.arC() == null || !aim.arC().aqq();
    }

    public com.baidu.swan.apps.api.c.b lD(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "start open tab bar");
        }
        return O(str, true);
    }

    public com.baidu.swan.apps.api.c.b lE(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "start close tab bar");
        }
        return O(str, false);
    }

    private com.baidu.swan.apps.api.c.b O(String str, final boolean z) {
        if (amk()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.c.b(1001, "fail not TabBar page");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bp = com.baidu.swan.apps.api.d.b.bp("Api-TabBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bp.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bp.second;
        final String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        final boolean optBoolean = jSONObject.optBoolean("animation");
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.g.1
            @Override // java.lang.Runnable
            public void run() {
                boolean hf;
                com.baidu.swan.apps.tabbar.b.a amj = g.amj();
                if (amj == null) {
                    com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
                    g.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                if (z) {
                    hf = amj.hg(optBoolean);
                } else {
                    hf = amj.hf(optBoolean);
                }
                if (!hf) {
                    com.baidu.swan.apps.console.c.e("Api-TabBar", (z ? "open" : "close") + "bottom bar fail");
                    g.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                }
                g.this.a(optString, new com.baidu.swan.apps.api.c.b(0));
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }
}
