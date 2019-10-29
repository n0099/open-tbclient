package com.baidu.swan.apps.x.a.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = b.class.getSimpleName();
    public g aUB;
    public String id;
    public String aUz = "";
    public boolean aUA = false;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            this.id = jSONObject.optString("controlId");
            this.aUB = new g();
            this.aUB.parseFromJson(jSONObject.optJSONObject("position"));
            this.aUz = jSONObject.optString("iconPath");
            this.aUA = jSONObject.optBoolean("clickable");
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.aUB == null || !this.aUB.isValid() || TextUtils.isEmpty(this.aUz)) ? false : true;
    }
}
