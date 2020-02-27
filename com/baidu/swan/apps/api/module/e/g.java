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

    public com.baidu.swan.apps.api.b.b fw(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "handle: " + str);
        }
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> ar = com.baidu.swan.apps.api.c.b.ar("Api-TabBar", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) ar.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        int optInt = ((JSONObject) ar.second).optInt("index");
        if (JM()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.b.b(1001, "fail not TabBar page");
        }
        com.baidu.swan.apps.tabbar.b.a JL = JL();
        if (JL == null) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
            return new com.baidu.swan.apps.api.b.b(1001, "tabBarViewController is null");
        } else if (!JL.hb(optInt)) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "close red dot fail");
            return new com.baidu.swan.apps.api.b.b(1001, "close red dot fail");
        } else {
            return new com.baidu.swan.apps.api.b.b(0);
        }
    }

    public com.baidu.swan.apps.api.b.b fx(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "handle: " + str);
        }
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> ar = com.baidu.swan.apps.api.c.b.ar("Api-TabBar", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) ar.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) ar.second;
        if (JM()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.b.b(1001, "fail not TabBar page");
        }
        com.baidu.swan.apps.tabbar.b.a JL = JL();
        if (JL == null) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
            return new com.baidu.swan.apps.api.b.b(1001, "tabBarViewController is null");
        } else if (!JL.b(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "set tab bar item fail");
            return new com.baidu.swan.apps.api.b.b(1001, "set tab bar item fail");
        } else {
            return new com.baidu.swan.apps.api.b.b(0);
        }
    }

    public static com.baidu.swan.apps.tabbar.b.a JL() {
        com.baidu.swan.apps.core.d.d On;
        com.baidu.swan.apps.core.d.e GA = com.baidu.swan.apps.y.f.WQ().GA();
        if (GA == null || (On = GA.On()) == null) {
            return null;
        }
        return On.NZ();
    }

    public static boolean JM() {
        com.baidu.swan.apps.core.d.e GA = com.baidu.swan.apps.y.f.WQ().GA();
        return GA == null || GA.Om() == null || !GA.Om().Nu();
    }
}
