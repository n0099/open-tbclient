package com.baidu.swan.gamecenter.b;

import android.support.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends com.baidu.swan.gamecenter.c.a {
    public b() {
        super("echoSync");
    }

    @Override // com.baidu.swan.gamecenter.c.a
    public com.baidu.swan.apps.api.c.b b(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        int optInt = jSONObject.optInt("status", 0);
        return optInt == 0 ? new com.baidu.swan.apps.api.c.b(optInt, jSONObject.optJSONObject("data")) : new com.baidu.swan.apps.api.c.b(optInt, jSONObject.optString("message"));
    }
}
