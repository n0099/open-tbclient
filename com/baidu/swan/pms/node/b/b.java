package com.baidu.swan.pms.node.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.c.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    private static volatile b etq;
    private a etr = new a();

    public static b bdq() {
        if (etq == null) {
            synchronized (b.class) {
                if (etq == null) {
                    etq = new b();
                }
            }
        }
        return etq;
    }

    private b() {
    }

    public String getVersion() {
        return this.etr.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cW(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("version");
            if (!TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject.optString("data");
                if (!TextUtils.isEmpty(optString2)) {
                    this.etr.edit().putString("version", optString).putString("data", optString2).apply();
                }
            }
        }
    }

    @NonNull
    public com.baidu.swan.pms.node.b.a bdr() {
        com.baidu.swan.pms.node.b.a aVar;
        try {
            aVar = com.baidu.swan.pms.node.b.a.cV(new JSONObject(this.etr.getString("data", "")));
        } catch (JSONException e) {
            e.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return com.baidu.swan.pms.node.b.a.etp;
        }
        return aVar;
    }

    /* loaded from: classes6.dex */
    private static class a extends i {
        private a() {
            super("swan_clean_stratey");
        }
    }
}
