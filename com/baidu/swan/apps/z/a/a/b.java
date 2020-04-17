package com.baidu.swan.apps.z.a.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public g bYE;
    public String id;
    public String bYD = "";
    public boolean aME = false;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            this.id = jSONObject.optString("controlId");
            if (TextUtils.isEmpty(this.id)) {
                this.id = jSONObject.optString("id");
            }
            this.bYE = new g();
            this.bYE.parseFromJson(jSONObject.optJSONObject("position"));
            this.bYD = jSONObject.optString("iconPath");
            this.aME = jSONObject.optBoolean("clickable");
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.bYE == null || !this.bYE.isValid() || TextUtils.isEmpty(this.bYD)) ? false : true;
    }
}
