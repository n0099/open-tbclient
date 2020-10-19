package com.baidu.swan.apps.api.module.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.ap.ak;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g extends com.baidu.swan.apps.api.a.d {
    public g(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b ks(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "handle: " + str);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bc = com.baidu.swan.apps.api.d.b.bc("Api-TabBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bc.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        int optInt = ((JSONObject) bc.second).optInt("index");
        if (afq()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.c.b(1001, "fail not TabBar page");
        }
        com.baidu.swan.apps.tabbar.b.a afp = afp();
        if (afp == null) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
            return new com.baidu.swan.apps.api.c.b(1001, "tabBarViewController is null");
        } else if (!afp.kO(optInt)) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "close red dot fail");
            return new com.baidu.swan.apps.api.c.b(1001, "close red dot fail");
        } else {
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    public com.baidu.swan.apps.api.c.b kt(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "handle: " + str);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bc = com.baidu.swan.apps.api.d.b.bc("Api-TabBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bc.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bc.second;
        if (afq()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.c.b(1001, "fail not TabBar page");
        }
        com.baidu.swan.apps.tabbar.b.a afp = afp();
        if (afp == null) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
            return new com.baidu.swan.apps.api.c.b(1001, "tabBarViewController is null");
        } else if (!afp.b(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "set tab bar item fail");
            return new com.baidu.swan.apps.api.c.b(1001, "set tab bar item fail");
        } else {
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    public static com.baidu.swan.apps.tabbar.b.a afp() {
        com.baidu.swan.apps.core.d.e akJ;
        com.baidu.swan.apps.core.d.f abs = com.baidu.swan.apps.v.f.avu().abs();
        if (abs == null || (akJ = abs.akJ()) == null) {
            return null;
        }
        return akJ.aku();
    }

    public static boolean afq() {
        com.baidu.swan.apps.core.d.f abs = com.baidu.swan.apps.v.f.avu().abs();
        return abs == null || abs.akI() == null || !abs.akI().ajw();
    }

    public com.baidu.swan.apps.api.c.b ku(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "start open tab bar");
        }
        return L(str, true);
    }

    public com.baidu.swan.apps.api.c.b kv(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "start close tab bar");
        }
        return L(str, false);
    }

    private com.baidu.swan.apps.api.c.b L(String str, final boolean z) {
        if (afq()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.c.b(1001, "fail not TabBar page");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bc = com.baidu.swan.apps.api.d.b.bc("Api-TabBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bc.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bc.second;
        final String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        final boolean optBoolean = jSONObject.optBoolean("animation");
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.g.1
            @Override // java.lang.Runnable
            public void run() {
                boolean gr;
                com.baidu.swan.apps.tabbar.b.a afp = g.afp();
                if (afp == null) {
                    com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
                    g.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                if (z) {
                    gr = afp.gs(optBoolean);
                } else {
                    gr = afp.gr(optBoolean);
                }
                if (!gr) {
                    com.baidu.swan.apps.console.c.e("Api-TabBar", (z ? "open" : "close") + "bottom bar fail");
                    g.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                }
                g.this.a(optString, new com.baidu.swan.apps.api.c.b(0));
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }
}
