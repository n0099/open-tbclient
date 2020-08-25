package com.baidu.swan.pms.node.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.c.i;
import com.baidu.swan.pms.node.Node;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class b {
    private static volatile b dGw;
    private a dGx = new a();

    public static b aUz() {
        if (dGw == null) {
            synchronized (b.class) {
                if (dGw == null) {
                    dGw = new b();
                }
            }
        }
        return dGw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String aUA() {
        return this.dGx.getString("ceres_info", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String aUB() {
        return this.dGx.getString("global_info", "0");
    }

    private b() {
    }

    public com.baidu.swan.pms.node.a.a cx(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d(Node.TAG, "ceres info " + jSONObject.toString());
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("ceres_info");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("global_info");
        if (optJSONObject == null || optJSONObject2 == null) {
            return null;
        }
        String optString = optJSONObject.optString("version");
        JSONArray optJSONArray = optJSONObject.optJSONArray("data");
        if (TextUtils.isEmpty(optString) || optJSONArray == null) {
            return null;
        }
        String optString2 = optJSONObject2.optString("version");
        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("data");
        if (TextUtils.isEmpty(optString) || optJSONObject3 == null) {
            return null;
        }
        this.dGx.edit().putString("ceres_info", optString).putString("global_info", optString2).apply();
        return new com.baidu.swan.pms.node.a.a(optJSONArray, optJSONObject3);
    }

    /* loaded from: classes14.dex */
    private static class a extends i {
        private a() {
            super("updatecore_node_ceres");
        }
    }
}
