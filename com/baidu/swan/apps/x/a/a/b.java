package com.baidu.swan.apps.x.a.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = b.class.getSimpleName();
    public String azh = "";
    public boolean azi = false;
    public g azj;
    public String id;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            this.id = jSONObject.optString("controlId");
            this.azj = new g();
            this.azj.parseFromJson(jSONObject.optJSONObject("position"));
            this.azh = jSONObject.optString("iconPath");
            this.azi = jSONObject.optBoolean("clickable");
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.azj == null || !this.azj.isValid() || TextUtils.isEmpty(this.azh)) ? false : true;
    }
}
