package com.baidu.swan.apps.component.a.b;

import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.apps.component.a.d.b {
    public String coS;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.coS = "";
    }

    @Override // com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.coS = jSONObject.optString("src");
        }
    }
}
