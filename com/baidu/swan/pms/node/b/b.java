package com.baidu.swan.pms.node.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.c.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private static volatile b evw;
    private a evx = new a();

    public static b bdD() {
        if (evw == null) {
            synchronized (b.class) {
                if (evw == null) {
                    evw = new b();
                }
            }
        }
        return evw;
    }

    private b() {
    }

    public String getVersion() {
        return this.evx.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cT(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("version");
            if (!TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject.optString("data");
                if (!TextUtils.isEmpty(optString2)) {
                    this.evx.edit().putString("version", optString).putString("data", optString2).apply();
                }
            }
        }
    }

    @NonNull
    public com.baidu.swan.pms.node.b.a bdE() {
        com.baidu.swan.pms.node.b.a aVar;
        try {
            aVar = com.baidu.swan.pms.node.b.a.cS(new JSONObject(this.evx.getString("data", "")));
        } catch (JSONException e) {
            e.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return com.baidu.swan.pms.node.b.a.evv;
        }
        return aVar;
    }

    /* loaded from: classes3.dex */
    private static class a extends i {
        private a() {
            super("swan_clean_stratey");
        }
    }
}
