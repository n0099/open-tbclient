package com.baidu.swan.b.c;

import android.support.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.b.d.a {
    public a() {
        super("echo");
    }

    @Override // com.baidu.swan.b.d.a
    public com.baidu.swan.apps.api.b.b b(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.p.b bVar) {
        int optInt = jSONObject.optInt("status", 0);
        String optString = jSONObject.optString("message");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optInt == 0) {
            bVar.K(optJSONObject);
            return null;
        }
        bVar.onFail(optInt, optString);
        return null;
    }
}
