package com.baidu.swan.gamecenter.b;

import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.swan.gamecenter.c.a {
    public a() {
        super("echo");
    }

    @Override // com.baidu.swan.gamecenter.c.a
    public com.baidu.swan.apps.api.c.b b(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        int optInt = jSONObject.optInt("status", 0);
        String optString = jSONObject.optString("message");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optInt == 0) {
            bVar.aI(optJSONObject);
            return null;
        }
        bVar.onFail(optInt, optString);
        return null;
    }
}
