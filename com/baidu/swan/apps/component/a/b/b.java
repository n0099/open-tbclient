package com.baidu.swan.apps.component.a.b;

import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public String cBD;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.cBD = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cBD = jSONObject.optString("src");
        }
    }
}
