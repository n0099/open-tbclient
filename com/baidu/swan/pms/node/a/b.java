package com.baidu.swan.pms.node.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.c.i;
import com.baidu.swan.pms.node.Node;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class b {
    private static volatile b dUF;
    private a dUG = new a();

    public static b aXU() {
        if (dUF == null) {
            synchronized (b.class) {
                if (dUF == null) {
                    dUF = new b();
                }
            }
        }
        return dUF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String aXV() {
        return this.dUG.getString("ceres_info", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String aXW() {
        return this.dUG.getString("global_info", "0");
    }

    private b() {
    }

    public com.baidu.swan.pms.node.a.a cH(JSONObject jSONObject) {
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
        this.dUG.edit().putString("ceres_info", optString).putString("global_info", optString2).apply();
        return new com.baidu.swan.pms.node.a.a(optJSONArray, optJSONObject3);
    }

    /* loaded from: classes15.dex */
    private static class a extends i {
        private a() {
            super("updatecore_node_ceres");
        }
    }
}
