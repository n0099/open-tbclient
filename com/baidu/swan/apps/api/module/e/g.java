package com.baidu.swan.apps.api.module.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.aq.al;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g extends com.baidu.swan.apps.api.a.d {
    public g(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b hP(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "handle: " + str);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aS = com.baidu.swan.apps.api.d.b.aS("Api-TabBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aS.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        int optInt = ((JSONObject) aS.second).optInt("index");
        if (VP()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.c.b(1001, "fail not TabBar page");
        }
        com.baidu.swan.apps.tabbar.b.a VO = VO();
        if (VO == null) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
            return new com.baidu.swan.apps.api.c.b(1001, "tabBarViewController is null");
        } else if (!VO.hY(optInt)) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "close red dot fail");
            return new com.baidu.swan.apps.api.c.b(1001, "close red dot fail");
        } else {
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    public com.baidu.swan.apps.api.c.b hQ(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "handle: " + str);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aS = com.baidu.swan.apps.api.d.b.aS("Api-TabBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aS.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aS.second;
        if (VP()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.c.b(1001, "fail not TabBar page");
        }
        com.baidu.swan.apps.tabbar.b.a VO = VO();
        if (VO == null) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
            return new com.baidu.swan.apps.api.c.b(1001, "tabBarViewController is null");
        } else if (!VO.b(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "set tab bar item fail");
            return new com.baidu.swan.apps.api.c.b(1001, "set tab bar item fail");
        } else {
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    public static com.baidu.swan.apps.tabbar.b.a VO() {
        com.baidu.swan.apps.core.d.e abb;
        com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc == null || (abb = Sc.abb()) == null) {
            return null;
        }
        return abb.aaO();
    }

    public static boolean VP() {
        com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        return Sc == null || Sc.aba() == null || !Sc.aba().ZR();
    }

    public com.baidu.swan.apps.api.c.b hR(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "start open tab bar");
        }
        return C(str, true);
    }

    public com.baidu.swan.apps.api.c.b hS(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "start close tab bar");
        }
        return C(str, false);
    }

    private com.baidu.swan.apps.api.c.b C(String str, final boolean z) {
        if (VP()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.c.b(1001, "fail not TabBar page");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aS = com.baidu.swan.apps.api.d.b.aS("Api-TabBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aS.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aS.second;
        final String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        final boolean optBoolean = jSONObject.optBoolean("animation");
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.g.1
            @Override // java.lang.Runnable
            public void run() {
                boolean fD;
                com.baidu.swan.apps.tabbar.b.a VO = g.VO();
                if (VO == null) {
                    com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
                    g.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                if (z) {
                    fD = VO.fE(optBoolean);
                } else {
                    fD = VO.fD(optBoolean);
                }
                if (!fD) {
                    com.baidu.swan.apps.console.c.e("Api-TabBar", (z ? "open" : "close") + "bottom bar fail");
                    g.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                }
                g.this.a(optString, new com.baidu.swan.apps.api.c.b(0));
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }
}
