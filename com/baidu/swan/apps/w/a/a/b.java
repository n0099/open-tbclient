package com.baidu.swan.apps.w.a.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public g cxW;
    public String id;
    public String cxV = "";
    public boolean bbY = false;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            this.id = jSONObject.optString("controlId");
            if (TextUtils.isEmpty(this.id)) {
                this.id = jSONObject.optString("id");
            }
            this.cxW = new g();
            this.cxW.parseFromJson(jSONObject.optJSONObject("position"));
            this.cxV = jSONObject.optString("iconPath");
            this.bbY = jSONObject.optBoolean("clickable");
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.cxW == null || !this.cxW.isValid() || TextUtils.isEmpty(this.cxV)) ? false : true;
    }
}
