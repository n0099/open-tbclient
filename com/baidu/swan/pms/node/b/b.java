package com.baidu.swan.pms.node.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.d.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class b {
    private static volatile b dxx;
    private a dxy = new a();

    public static b aMd() {
        if (dxx == null) {
            synchronized (b.class) {
                if (dxx == null) {
                    dxx = new b();
                }
            }
        }
        return dxx;
    }

    private b() {
    }

    public String getVersion() {
        return this.dxy.getString("version", "0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cu(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("version");
            if (!TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject.optString("data");
                if (!TextUtils.isEmpty(optString2)) {
                    this.dxy.edit().putString("version", optString).putString("data", optString2).apply();
                }
            }
        }
    }

    @NonNull
    public com.baidu.swan.pms.node.b.a aMe() {
        com.baidu.swan.pms.node.b.a aVar;
        try {
            aVar = com.baidu.swan.pms.node.b.a.ct(new JSONObject(this.dxy.getString("data", "")));
        } catch (JSONException e) {
            e.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return com.baidu.swan.pms.node.b.a.dxw;
        }
        return aVar;
    }

    /* loaded from: classes19.dex */
    private static class a extends i {
        private a() {
            super("swan_clean_stratey");
        }
    }
}
