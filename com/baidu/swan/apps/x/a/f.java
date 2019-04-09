package com.baidu.swan.apps.x.a;

import android.text.TextUtils;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends c {
    public com.baidu.swan.apps.x.a.a.c ayM;
    public boolean azb;
    public double azc;
    public String aza = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.x.a.c, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.aza = jSONObject.optString("markerId");
            this.ayM = new com.baidu.swan.apps.x.a.a.c();
            this.ayM.parseFromJson(jSONObject.optJSONObject("destination"));
            this.azb = jSONObject.optBoolean("autoRotate");
            this.azc = jSONObject.optDouble("rotate");
            this.duration = Math.abs(jSONObject.optInt(UBC.CONTENT_KEY_DURATION, this.duration));
        }
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.aBH) || TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.aza) || this.ayM == null || !this.ayM.isValid()) ? false : true;
    }
}
