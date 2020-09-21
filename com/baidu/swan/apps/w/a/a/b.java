package com.baidu.swan.apps.w.a.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public g cAb;
    public String id;
    public String cAa = "";
    public boolean beK = false;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            this.id = jSONObject.optString("controlId");
            if (TextUtils.isEmpty(this.id)) {
                this.id = jSONObject.optString("id");
            }
            this.cAb = new g();
            this.cAb.parseFromJson(jSONObject.optJSONObject("position"));
            this.cAa = jSONObject.optString("iconPath");
            this.beK = jSONObject.optBoolean("clickable");
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.cAb == null || !this.cAb.isValid() || TextUtils.isEmpty(this.cAa)) ? false : true;
    }
}
