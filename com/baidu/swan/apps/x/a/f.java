package com.baidu.swan.apps.x.a;

import android.text.TextUtils;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends c {
    public boolean aAG;
    public double aAH;
    public com.baidu.swan.apps.x.a.a.c aAr;
    public String aAF = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.x.a.c, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.aAF = jSONObject.optString("markerId");
            this.aAr = new com.baidu.swan.apps.x.a.a.c();
            this.aAr.parseFromJson(jSONObject.optJSONObject("destination"));
            this.aAG = jSONObject.optBoolean("autoRotate");
            this.aAH = jSONObject.optDouble("rotate");
            this.duration = Math.abs(jSONObject.optInt(UBC.CONTENT_KEY_DURATION, this.duration));
        }
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.aDU) || TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.aAF) || this.aAr == null || !this.aAr.isValid()) ? false : true;
    }
}
