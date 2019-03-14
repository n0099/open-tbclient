package com.baidu.swan.apps.x.a.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = b.class.getSimpleName();
    public String azd = "";
    public boolean aze = false;
    public g azf;
    public String id;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            this.id = jSONObject.optString("controlId");
            this.azf = new g();
            this.azf.parseFromJson(jSONObject.optJSONObject("position"));
            this.azd = jSONObject.optString("iconPath");
            this.aze = jSONObject.optBoolean("clickable");
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.azf == null || !this.azf.isValid() || TextUtils.isEmpty(this.azd)) ? false : true;
    }
}
