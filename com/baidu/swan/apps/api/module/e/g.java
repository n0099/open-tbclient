package com.baidu.swan.apps.api.module.e;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class g extends com.baidu.swan.apps.api.a.c {
    public g(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b fe(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "handle: " + str);
        }
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> ag = com.baidu.swan.apps.api.c.b.ag("Api-TabBar", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) ag.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        int optInt = ((JSONObject) ag.second).optInt("index");
        if (Hb()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.b.b(1001, "fail not TabBar page");
        }
        com.baidu.swan.apps.tabbar.b.a Ha = Ha();
        if (Ha == null) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
            return new com.baidu.swan.apps.api.b.b(1001, "tabBarViewController is null");
        } else if (!Ha.gK(optInt)) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "close red dot fail");
            return new com.baidu.swan.apps.api.b.b(1001, "close red dot fail");
        } else {
            return new com.baidu.swan.apps.api.b.b(0);
        }
    }

    public com.baidu.swan.apps.api.b.b ff(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "handle: " + str);
        }
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> ag = com.baidu.swan.apps.api.c.b.ag("Api-TabBar", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) ag.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) ag.second;
        if (Hb()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.b.b(1001, "fail not TabBar page");
        }
        com.baidu.swan.apps.tabbar.b.a Ha = Ha();
        if (Ha == null) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
            return new com.baidu.swan.apps.api.b.b(1001, "tabBarViewController is null");
        } else if (!Ha.b(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "set tab bar item fail");
            return new com.baidu.swan.apps.api.b.b(1001, "set tab bar item fail");
        } else {
            return new com.baidu.swan.apps.api.b.b(0);
        }
    }

    public static com.baidu.swan.apps.tabbar.b.a Ha() {
        com.baidu.swan.apps.core.d.d LD;
        com.baidu.swan.apps.core.d.e DP = com.baidu.swan.apps.y.f.Uf().DP();
        if (DP == null || (LD = DP.LD()) == null) {
            return null;
        }
        return LD.Lp();
    }

    public static boolean Hb() {
        com.baidu.swan.apps.core.d.e DP = com.baidu.swan.apps.y.f.Uf().DP();
        return DP == null || DP.LC() == null || !DP.LC().KJ();
    }
}
