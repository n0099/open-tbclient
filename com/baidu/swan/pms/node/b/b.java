package com.baidu.swan.pms.node.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.c.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class b {
    private static volatile b dGH;
    private a dGI = new a();

    public static b aUC() {
        if (dGH == null) {
            synchronized (b.class) {
                if (dGH == null) {
                    dGH = new b();
                }
            }
        }
        return dGH;
    }

    private b() {
    }

    public String getVersion() {
        return this.dGI.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cz(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("version");
            if (!TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject.optString("data");
                if (!TextUtils.isEmpty(optString2)) {
                    this.dGI.edit().putString("version", optString).putString("data", optString2).apply();
                }
            }
        }
    }

    @NonNull
    public com.baidu.swan.pms.node.b.a aUD() {
        com.baidu.swan.pms.node.b.a aVar;
        try {
            aVar = com.baidu.swan.pms.node.b.a.cy(new JSONObject(this.dGI.getString("data", "")));
        } catch (JSONException e) {
            e.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return com.baidu.swan.pms.node.b.a.dGG;
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
