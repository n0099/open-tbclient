package com.baidu.swan.apps.w.a.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public g cUC;
    public String id;
    public String cUB = "";
    public boolean bjS = false;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            this.id = jSONObject.optString("controlId");
            if (TextUtils.isEmpty(this.id)) {
                this.id = jSONObject.optString("id");
            }
            this.cUC = new g();
            this.cUC.parseFromJson(jSONObject.optJSONObject("position"));
            this.cUB = jSONObject.optString("iconPath");
            this.bjS = jSONObject.optBoolean("clickable");
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.cUC == null || !this.cUC.isValid() || TextUtils.isEmpty(this.cUB)) ? false : true;
    }
}
