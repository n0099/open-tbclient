package com.baidu.swan.pms.node.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.c.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private static volatile b ewX;
    private a ewY = new a();

    public static b bdF() {
        if (ewX == null) {
            synchronized (b.class) {
                if (ewX == null) {
                    ewX = new b();
                }
            }
        }
        return ewX;
    }

    private b() {
    }

    public String getVersion() {
        return this.ewY.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cV(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("version");
            if (!TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject.optString("data");
                if (!TextUtils.isEmpty(optString2)) {
                    this.ewY.edit().putString("version", optString).putString("data", optString2).apply();
                }
            }
        }
    }

    @NonNull
    public com.baidu.swan.pms.node.b.a bdG() {
        com.baidu.swan.pms.node.b.a aVar;
        try {
            aVar = com.baidu.swan.pms.node.b.a.cU(new JSONObject(this.ewY.getString("data", "")));
        } catch (JSONException e) {
            e.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return com.baidu.swan.pms.node.b.a.ewW;
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
