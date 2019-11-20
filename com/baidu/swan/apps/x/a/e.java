package com.baidu.swan.apps.x.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends c {
    public String name = "";
    public String address = "";

    @Override // com.baidu.swan.apps.x.a.c, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has("scale")) {
                this.aTM = jSONObject.optDouble("scale", 18.0d);
            }
            if (jSONObject.has("name")) {
                this.name = jSONObject.optString("name");
            }
            if (jSONObject.has("address")) {
                this.address = jSONObject.optString("address");
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.aXp) || this.aTL == null || !this.aTL.isValid()) ? false : true;
    }
}
