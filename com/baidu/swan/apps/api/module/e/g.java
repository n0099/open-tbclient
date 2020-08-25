package com.baidu.swan.apps.api.module.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.ap.ak;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g extends com.baidu.swan.apps.api.a.d {
    public g(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b jm(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "handle: " + str);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aX = com.baidu.swan.apps.api.d.b.aX("Api-TabBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aX.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        int optInt = ((JSONObject) aX.second).optInt("index");
        if (abV()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.c.b(1001, "fail not TabBar page");
        }
        com.baidu.swan.apps.tabbar.b.a abU = abU();
        if (abU == null) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
            return new com.baidu.swan.apps.api.c.b(1001, "tabBarViewController is null");
        } else if (!abU.kg(optInt)) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "close red dot fail");
            return new com.baidu.swan.apps.api.c.b(1001, "close red dot fail");
        } else {
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    public com.baidu.swan.apps.api.c.b jn(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "handle: " + str);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aX = com.baidu.swan.apps.api.d.b.aX("Api-TabBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aX.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aX.second;
        if (abV()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.c.b(1001, "fail not TabBar page");
        }
        com.baidu.swan.apps.tabbar.b.a abU = abU();
        if (abU == null) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
            return new com.baidu.swan.apps.api.c.b(1001, "tabBarViewController is null");
        } else if (!abU.b(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "set tab bar item fail");
            return new com.baidu.swan.apps.api.c.b(1001, "set tab bar item fail");
        } else {
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    public static com.baidu.swan.apps.tabbar.b.a abU() {
        com.baidu.swan.apps.core.d.e aho;
        com.baidu.swan.apps.core.d.f XX = com.baidu.swan.apps.v.f.arY().XX();
        if (XX == null || (aho = XX.aho()) == null) {
            return null;
        }
        return aho.agZ();
    }

    public static boolean abV() {
        com.baidu.swan.apps.core.d.f XX = com.baidu.swan.apps.v.f.arY().XX();
        return XX == null || XX.ahn() == null || !XX.ahn().agb();
    }

    public com.baidu.swan.apps.api.c.b jo(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "start open tab bar");
        }
        return H(str, true);
    }

    public com.baidu.swan.apps.api.c.b jp(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "start close tab bar");
        }
        return H(str, false);
    }

    private com.baidu.swan.apps.api.c.b H(String str, final boolean z) {
        if (abV()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.c.b(1001, "fail not TabBar page");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aX = com.baidu.swan.apps.api.d.b.aX("Api-TabBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aX.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aX.second;
        final String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        final boolean optBoolean = jSONObject.optBoolean("animation");
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.g.1
            @Override // java.lang.Runnable
            public void run() {
                boolean fW;
                com.baidu.swan.apps.tabbar.b.a abU = g.abU();
                if (abU == null) {
                    com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
                    g.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                if (z) {
                    fW = abU.fX(optBoolean);
                } else {
                    fW = abU.fW(optBoolean);
                }
                if (!fW) {
                    com.baidu.swan.apps.console.c.e("Api-TabBar", (z ? "open" : "close") + "bottom bar fail");
                    g.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                }
                g.this.a(optString, new com.baidu.swan.apps.api.c.b(0));
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }
}
