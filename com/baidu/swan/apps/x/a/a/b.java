package com.baidu.swan.apps.x.a.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public g cjm;
    public String id;
    public String cjl = "";
    public boolean aSO = false;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            this.id = jSONObject.optString("controlId");
            if (TextUtils.isEmpty(this.id)) {
                this.id = jSONObject.optString("id");
            }
            this.cjm = new g();
            this.cjm.parseFromJson(jSONObject.optJSONObject("position"));
            this.cjl = jSONObject.optString("iconPath");
            this.aSO = jSONObject.optBoolean("clickable");
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.cjm == null || !this.cjm.isValid() || TextUtils.isEmpty(this.cjl)) ? false : true;
    }
}
