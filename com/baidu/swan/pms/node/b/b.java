package com.baidu.swan.pms.node.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.e.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static volatile b dmU;
    private a dmV = new a();

    public static b aHf() {
        if (dmU == null) {
            synchronized (b.class) {
                if (dmU == null) {
                    dmU = new b();
                }
            }
        }
        return dmU;
    }

    private b() {
    }

    public String getVersion() {
        return this.dmV.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ch(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("version");
            if (!TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject.optString("data");
                if (!TextUtils.isEmpty(optString2)) {
                    this.dmV.edit().putString("version", optString).putString("data", optString2).apply();
                }
            }
        }
    }

    @NonNull
    public com.baidu.swan.pms.node.b.a aHg() {
        com.baidu.swan.pms.node.b.a aVar;
        try {
            aVar = com.baidu.swan.pms.node.b.a.cg(new JSONObject(this.dmV.getString("data", "")));
        } catch (JSONException e) {
            e.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return com.baidu.swan.pms.node.b.a.dmT;
        }
        return aVar;
    }

    /* loaded from: classes11.dex */
    private static class a extends j {
        private a() {
            super("swan_clean_stratey");
        }
    }
}
