package com.baidu.swan.config.core.b;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class a implements c {
    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject bi(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.optInt("errno", -1) == 0) {
            return jSONObject.optJSONObject("data");
        }
        return null;
    }
}
