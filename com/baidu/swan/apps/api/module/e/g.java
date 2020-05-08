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
        if (RD()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.b.b(1001, "fail not TabBar page");
        }
        com.baidu.swan.apps.tabbar.b.a RC = RC();
        if (RC == null) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
            return new com.baidu.swan.apps.api.b.b(1001, "tabBarViewController is null");
        } else if (!RC.hi(optInt)) {
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
        if (RD()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.b.b(1001, "fail not TabBar page");
        }
        com.baidu.swan.apps.tabbar.b.a RC = RC();
        if (RC == null) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
            return new com.baidu.swan.apps.api.b.b(1001, "tabBarViewController is null");
        } else if (!RC.b(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "set tab bar item fail");
            return new com.baidu.swan.apps.api.b.b(1001, "set tab bar item fail");
        } else {
            return new com.baidu.swan.apps.api.b.b(0);
        }
    }

    public static com.baidu.swan.apps.tabbar.b.a RC() {
        com.baidu.swan.apps.core.d.d Wf;
        com.baidu.swan.apps.core.d.e Ot = com.baidu.swan.apps.y.f.aeJ().Ot();
        if (Ot == null || (Wf = Ot.Wf()) == null) {
            return null;
        }
        return Wf.VR();
    }

    public static boolean RD() {
        com.baidu.swan.apps.core.d.e Ot = com.baidu.swan.apps.y.f.aeJ().Ot();
        return Ot == null || Ot.We() == null || !Ot.We().Vl();
    }
}
