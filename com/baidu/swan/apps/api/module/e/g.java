package com.baidu.swan.apps.api.module.e;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.ak;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class g extends com.baidu.swan.apps.api.a.d {
    public g(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lu(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "handle: " + str);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bo = com.baidu.swan.apps.api.d.b.bo("Api-TabBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bo.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        int optInt = ((JSONObject) bo.second).optInt("index");
        if (anv()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.c.b(1001, "fail not TabBar page");
        }
        com.baidu.swan.apps.tabbar.b.a anu = anu();
        if (anu == null) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
            return new com.baidu.swan.apps.api.c.b(1001, "tabBarViewController is null");
        } else if (!anu.lI(optInt)) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "close red dot fail");
            return new com.baidu.swan.apps.api.c.b(1001, "close red dot fail");
        } else {
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    public com.baidu.swan.apps.api.c.b lv(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "handle: " + str);
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bo = com.baidu.swan.apps.api.d.b.bo("Api-TabBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bo.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bo.second;
        if (anv()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.c.b(1001, "fail not TabBar page");
        }
        com.baidu.swan.apps.tabbar.b.a anu = anu();
        if (anu == null) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
            return new com.baidu.swan.apps.api.c.b(1001, "tabBarViewController is null");
        } else if (!anu.b(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "set tab bar item fail");
            return new com.baidu.swan.apps.api.c.b(1001, "set tab bar item fail");
        } else {
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    public static com.baidu.swan.apps.tabbar.b.a anu() {
        com.baidu.swan.apps.core.d.e asW;
        com.baidu.swan.apps.core.d.f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
        if (ajt == null || (asW = ajt.asW()) == null) {
            return null;
        }
        return asW.asH();
    }

    public static boolean anv() {
        com.baidu.swan.apps.core.d.f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
        return ajt == null || ajt.asV() == null || !ajt.asV().arD();
    }

    public com.baidu.swan.apps.api.c.b lw(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "start open tab bar");
        }
        return O(str, true);
    }

    public com.baidu.swan.apps.api.c.b lx(String str) {
        if (DEBUG) {
            Log.d("Api-TabBar", "start close tab bar");
        }
        return O(str, false);
    }

    private com.baidu.swan.apps.api.c.b O(String str, final boolean z) {
        if (anv()) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "fail not TabBar page");
            return new com.baidu.swan.apps.api.c.b(1001, "fail not TabBar page");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bo = com.baidu.swan.apps.api.d.b.bo("Api-TabBar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bo.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-TabBar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bo.second;
        final String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Api-TabBar", "callback is null");
            return new com.baidu.swan.apps.api.c.b(1001, "callback is null");
        }
        final boolean optBoolean = jSONObject.optBoolean("animation");
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.g.1
            @Override // java.lang.Runnable
            public void run() {
                boolean hx;
                com.baidu.swan.apps.tabbar.b.a anu = g.anu();
                if (anu == null) {
                    com.baidu.swan.apps.console.c.e("Api-TabBar", "tabBarViewController is null");
                    g.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                if (z) {
                    hx = anu.hy(optBoolean);
                } else {
                    hx = anu.hx(optBoolean);
                }
                if (!hx) {
                    com.baidu.swan.apps.console.c.e("Api-TabBar", (z ? "open" : "close") + "bottom bar fail");
                    g.this.a(optString, new com.baidu.swan.apps.api.c.b(1001));
                }
                g.this.a(optString, new com.baidu.swan.apps.api.c.b(0));
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }
}
