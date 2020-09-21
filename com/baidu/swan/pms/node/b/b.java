package com.baidu.swan.pms.node.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.c.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class b {
    private static volatile b dIL;
    private a dIM = new a();

    public static b aVo() {
        if (dIL == null) {
            synchronized (b.class) {
                if (dIL == null) {
                    dIL = new b();
                }
            }
        }
        return dIL;
    }

    private b() {
    }

    public String getVersion() {
        return this.dIM.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cC(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("version");
            if (!TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject.optString("data");
                if (!TextUtils.isEmpty(optString2)) {
                    this.dIM.edit().putString("version", optString).putString("data", optString2).apply();
                }
            }
        }
    }

    @NonNull
    public com.baidu.swan.pms.node.b.a aVp() {
        com.baidu.swan.pms.node.b.a aVar;
        try {
            aVar = com.baidu.swan.pms.node.b.a.cB(new JSONObject(this.dIM.getString("data", "")));
        } catch (JSONException e) {
            e.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return com.baidu.swan.pms.node.b.a.dIK;
        }
        return aVar;
    }

    /* loaded from: classes24.dex */
    private static class a extends i {
        private a() {
            super("swan_clean_stratey");
        }
    }
}
