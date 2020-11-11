package com.baidu.swan.pms.node.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.c.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class b {
    private static volatile b eja;
    private a ejb = new a();

    public static b bcq() {
        if (eja == null) {
            synchronized (b.class) {
                if (eja == null) {
                    eja = new b();
                }
            }
        }
        return eja;
    }

    private b() {
    }

    public String getVersion() {
        return this.ejb.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cS(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("version");
            if (!TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject.optString("data");
                if (!TextUtils.isEmpty(optString2)) {
                    this.ejb.edit().putString("version", optString).putString("data", optString2).apply();
                }
            }
        }
    }

    @NonNull
    public com.baidu.swan.pms.node.b.a bcr() {
        com.baidu.swan.pms.node.b.a aVar;
        try {
            aVar = com.baidu.swan.pms.node.b.a.cR(new JSONObject(this.ejb.getString("data", "")));
        } catch (JSONException e) {
            e.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return com.baidu.swan.pms.node.b.a.eiZ;
        }
        return aVar;
    }

    /* loaded from: classes15.dex */
    private static class a extends i {
        private a() {
            super("swan_clean_stratey");
        }
    }
}
