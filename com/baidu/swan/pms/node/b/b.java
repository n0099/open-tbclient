package com.baidu.swan.pms.node.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.c.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    private static volatile b eov;
    private a eow = new a();

    public static b beO() {
        if (eov == null) {
            synchronized (b.class) {
                if (eov == null) {
                    eov = new b();
                }
            }
        }
        return eov;
    }

    private b() {
    }

    public String getVersion() {
        return this.eow.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cO(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("version");
            if (!TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject.optString("data");
                if (!TextUtils.isEmpty(optString2)) {
                    this.eow.edit().putString("version", optString).putString("data", optString2).apply();
                }
            }
        }
    }

    @NonNull
    public com.baidu.swan.pms.node.b.a beP() {
        com.baidu.swan.pms.node.b.a aVar;
        try {
            aVar = com.baidu.swan.pms.node.b.a.cN(new JSONObject(this.eow.getString("data", "")));
        } catch (JSONException e) {
            e.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return com.baidu.swan.pms.node.b.a.eou;
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
