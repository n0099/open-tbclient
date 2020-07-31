package com.baidu.swan.gamecenter.b;

import android.support.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class a extends com.baidu.swan.gamecenter.c.a {
    public a() {
        super("echo");
    }

    @Override // com.baidu.swan.gamecenter.c.a
    public com.baidu.swan.apps.api.c.b b(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.n.b bVar) {
        int optInt = jSONObject.optInt("status", 0);
        String optString = jSONObject.optString("message");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optInt == 0) {
            bVar.aj(optJSONObject);
            return null;
        }
        bVar.onFail(optInt, optString);
        return null;
    }
}
