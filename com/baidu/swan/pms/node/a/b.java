package com.baidu.swan.pms.node.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.d.i;
import com.baidu.swan.pms.node.Node;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class b {
    private static volatile b dxq;
    private a dxr = new a();

    public static b aMa() {
        if (dxq == null) {
            synchronized (b.class) {
                if (dxq == null) {
                    dxq = new b();
                }
            }
        }
        return dxq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String aMb() {
        return this.dxr.getString("ceres_info", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String aMc() {
        return this.dxr.getString("global_info", "0");
    }

    private b() {
    }

    public com.baidu.swan.pms.node.a.a cs(JSONObject jSONObject) {
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
        this.dxr.edit().putString("ceres_info", optString).putString("global_info", optString2).apply();
        return new com.baidu.swan.pms.node.a.a(optJSONArray, optJSONObject3);
    }

    /* loaded from: classes19.dex */
    private static class a extends i {
        private a() {
            super("updatecore_node_ceres");
        }
    }
}
