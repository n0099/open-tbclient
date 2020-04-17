package com.baidu.swan.apps.api.module.e;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g extends com.baidu.swan.apps.api.a.c {
    public g(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b gJ(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "handle: " + str);
        }
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> az = com.baidu.swan.apps.api.c.b.az("Api-TabBar", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) az.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        int optInt = ((JSONObject) az.second).optInt("index");
        if (RE()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.b.b(1001, "fail not TabBar page");
        }
        com.baidu.swan.apps.tabbar.b.a RD = RD();
        if (RD == null) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
            return new com.baidu.swan.apps.api.b.b(1001, "tabBarViewController is null");
        } else if (!RD.hi(optInt)) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "close red dot fail");
            return new com.baidu.swan.apps.api.b.b(1001, "close red dot fail");
        } else {
            return new com.baidu.swan.apps.api.b.b(0);
        }
    }

    public com.baidu.swan.apps.api.b.b gK(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "handle: " + str);
        }
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> az = com.baidu.swan.apps.api.c.b.az("Api-TabBar", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) az.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) az.second;
        if (RE()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.b.b(1001, "fail not TabBar page");
        }
        com.baidu.swan.apps.tabbar.b.a RD = RD();
        if (RD == null) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
            return new com.baidu.swan.apps.api.b.b(1001, "tabBarViewController is null");
        } else if (!RD.b(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "set tab bar item fail");
            return new com.baidu.swan.apps.api.b.b(1001, "set tab bar item fail");
        } else {
            return new com.baidu.swan.apps.api.b.b(0);
        }
    }

    public static com.baidu.swan.apps.tabbar.b.a RD() {
        com.baidu.swan.apps.core.d.d Wg;
        com.baidu.swan.apps.core.d.e Ou = com.baidu.swan.apps.y.f.aeK().Ou();
        if (Ou == null || (Wg = Ou.Wg()) == null) {
            return null;
        }
        return Wg.VS();
    }

    public static boolean RE() {
        com.baidu.swan.apps.core.d.e Ou = com.baidu.swan.apps.y.f.aeK().Ou();
        return Ou == null || Ou.Wf() == null || !Ou.Wf().Vm();
    }
}
