package com.baidu.swan.pms.node.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.c.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class b {
    private static volatile b dGD;
    private a dGE = new a();

    public static b aUC() {
        if (dGD == null) {
            synchronized (b.class) {
                if (dGD == null) {
                    dGD = new b();
                }
            }
        }
        return dGD;
    }

    private b() {
    }

    public String getVersion() {
        return this.dGE.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cz(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("version");
            if (!TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject.optString("data");
                if (!TextUtils.isEmpty(optString2)) {
                    this.dGE.edit().putString("version", optString).putString("data", optString2).apply();
                }
            }
        }
    }

    @NonNull
    public com.baidu.swan.pms.node.b.a aUD() {
        com.baidu.swan.pms.node.b.a aVar;
        try {
            aVar = com.baidu.swan.pms.node.b.a.cy(new JSONObject(this.dGE.getString("data", "")));
        } catch (JSONException e) {
            e.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return com.baidu.swan.pms.node.b.a.dGC;
        }
        return aVar;
    }

    /* loaded from: classes14.dex */
    private static class a extends i {
        private a() {
            super("swan_clean_stratey");
        }
    }
}
