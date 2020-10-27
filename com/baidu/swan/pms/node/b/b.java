package com.baidu.swan.pms.node.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.c.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class b {
    private static volatile b edi;
    private a edj = new a();

    public static b aZQ() {
        if (edi == null) {
            synchronized (b.class) {
                if (edi == null) {
                    edi = new b();
                }
            }
        }
        return edi;
    }

    private b() {
    }

    public String getVersion() {
        return this.edj.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cM(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("version");
            if (!TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject.optString("data");
                if (!TextUtils.isEmpty(optString2)) {
                    this.edj.edit().putString("version", optString).putString("data", optString2).apply();
                }
            }
        }
    }

    @NonNull
    public com.baidu.swan.pms.node.b.a aZR() {
        com.baidu.swan.pms.node.b.a aVar;
        try {
            aVar = com.baidu.swan.pms.node.b.a.cL(new JSONObject(this.edj.getString("data", "")));
        } catch (JSONException e) {
            e.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return com.baidu.swan.pms.node.b.a.edh;
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
