package com.baidu.swan.apps.x.a;

import android.text.TextUtils;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends c {
    public double aAa;
    public com.baidu.swan.apps.x.a.a.c azK;
    public boolean azZ;
    public String azY = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.x.a.c, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.azY = jSONObject.optString("markerId");
            this.azK = new com.baidu.swan.apps.x.a.a.c();
            this.azK.parseFromJson(jSONObject.optJSONObject("destination"));
            this.azZ = jSONObject.optBoolean("autoRotate");
            this.aAa = jSONObject.optDouble("rotate");
            this.duration = Math.abs(jSONObject.optInt(UBC.CONTENT_KEY_DURATION, this.duration));
        }
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.aDm) || TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.azY) || this.azK == null || !this.azK.isValid()) ? false : true;
    }
}
