package com.baidu.swan.pms.node.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.e.j;
import com.baidu.swan.pms.node.Node;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static volatile b drz;
    private a drA = new a();

    public static b aIi() {
        if (drz == null) {
            synchronized (b.class) {
                if (drz == null) {
                    drz = new b();
                }
            }
        }
        return drz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String aIj() {
        return this.drA.getString("ceres_info", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String aIk() {
        return this.drA.getString("global_info", "0");
    }

    private b() {
    }

    public com.baidu.swan.pms.node.a.a cm(JSONObject jSONObject) {
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
        this.drA.edit().putString("ceres_info", optString).putString("global_info", optString2).apply();
        return new com.baidu.swan.pms.node.a.a(optJSONArray, optJSONObject3);
    }

    /* loaded from: classes11.dex */
    private static class a extends j {
        private a() {
            super("updatecore_node_ceres");
        }
    }
}
