package com.baidu.swan.apps.x.a.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static final String TAG = b.class.getSimpleName();
    public String azc = "";
    public boolean azd = false;
    public g aze;
    public String id;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            this.id = jSONObject.optString("controlId");
            this.aze = new g();
            this.aze.parseFromJson(jSONObject.optJSONObject("position"));
            this.azc = jSONObject.optString("iconPath");
            this.azd = jSONObject.optBoolean("clickable");
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.aze == null || !this.aze.isValid() || TextUtils.isEmpty(this.azc)) ? false : true;
    }
}
