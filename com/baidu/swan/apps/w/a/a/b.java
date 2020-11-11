package com.baidu.swan.apps.w.a.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public g daw;
    public String id;
    public String dav = "";
    public boolean blm = false;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            this.id = jSONObject.optString("controlId");
            if (TextUtils.isEmpty(this.id)) {
                this.id = jSONObject.optString("id");
            }
            this.daw = new g();
            this.daw.parseFromJson(jSONObject.optJSONObject("position"));
            this.dav = jSONObject.optString("iconPath");
            this.blm = jSONObject.optBoolean("clickable");
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.daw == null || !this.daw.isValid() || TextUtils.isEmpty(this.dav)) ? false : true;
    }
}
