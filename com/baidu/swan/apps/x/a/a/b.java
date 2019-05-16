package com.baidu.swan.apps.x.a.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = b.class.getSimpleName();
    public String aAf = "";
    public boolean aAg = false;
    public g aAh;
    public String id;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            this.id = jSONObject.optString("controlId");
            this.aAh = new g();
            this.aAh.parseFromJson(jSONObject.optJSONObject("position"));
            this.aAf = jSONObject.optString("iconPath");
            this.aAg = jSONObject.optBoolean("clickable");
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.aAh == null || !this.aAh.isValid() || TextUtils.isEmpty(this.aAf)) ? false : true;
    }
}
