package com.baidu.swan.apps.x.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends c {
    public com.baidu.swan.apps.x.a.a.c aAP;
    public boolean aBe;
    public double aBf;
    public String aBd = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.x.a.c, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.aBd = jSONObject.optString("markerId");
            this.aAP = new com.baidu.swan.apps.x.a.a.c();
            this.aAP.parseFromJson(jSONObject.optJSONObject("destination"));
            this.aBe = jSONObject.optBoolean("autoRotate");
            this.aBf = jSONObject.optDouble("rotate");
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.aEs) || TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.aBd) || this.aAP == null || !this.aAP.isValid()) ? false : true;
    }
}
