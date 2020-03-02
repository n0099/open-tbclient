package com.baidu.swan.apps.z.a.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public g bAl;
    public String id;
    public String iconPath = "";
    public boolean atm = false;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            this.id = jSONObject.optString("controlId");
            if (TextUtils.isEmpty(this.id)) {
                this.id = jSONObject.optString("id");
            }
            this.bAl = new g();
            this.bAl.parseFromJson(jSONObject.optJSONObject("position"));
            this.iconPath = jSONObject.optString("iconPath");
            this.atm = jSONObject.optBoolean("clickable");
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.bAl == null || !this.bAl.isValid() || TextUtils.isEmpty(this.iconPath)) ? false : true;
    }
}
