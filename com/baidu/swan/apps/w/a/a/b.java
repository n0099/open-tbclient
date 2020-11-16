package com.baidu.swan.apps.w.a.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public g cYL;
    public String id;
    public String cYK = "";
    public boolean bjB = false;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            this.id = jSONObject.optString("controlId");
            if (TextUtils.isEmpty(this.id)) {
                this.id = jSONObject.optString("id");
            }
            this.cYL = new g();
            this.cYL.parseFromJson(jSONObject.optJSONObject("position"));
            this.cYK = jSONObject.optString("iconPath");
            this.bjB = jSONObject.optBoolean("clickable");
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.cYL == null || !this.cYL.isValid() || TextUtils.isEmpty(this.cYK)) ? false : true;
    }
}
