package com.baidu.swan.b.c;

import android.support.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.b.d.a {
    public b() {
        super("echoSync");
    }

    @Override // com.baidu.swan.b.d.a
    public com.baidu.swan.apps.api.b.b b(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.p.b bVar) {
        int optInt = jSONObject.optInt("status", 0);
        return optInt == 0 ? new com.baidu.swan.apps.api.b.b(optInt, jSONObject.optJSONObject("data")) : new com.baidu.swan.apps.api.b.b(optInt, jSONObject.optString("message"));
    }
}
