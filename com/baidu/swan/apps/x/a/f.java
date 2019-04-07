package com.baidu.swan.apps.x.a;

import android.text.TextUtils;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends c {
    public com.baidu.swan.apps.x.a.a.c ayL;
    public boolean aza;
    public double azb;
    public String ayZ = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.x.a.c, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.ayZ = jSONObject.optString("markerId");
            this.ayL = new com.baidu.swan.apps.x.a.a.c();
            this.ayL.parseFromJson(jSONObject.optJSONObject("destination"));
            this.aza = jSONObject.optBoolean("autoRotate");
            this.azb = jSONObject.optDouble("rotate");
            this.duration = Math.abs(jSONObject.optInt(UBC.CONTENT_KEY_DURATION, this.duration));
        }
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.aBG) || TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.ayZ) || this.ayL == null || !this.ayL.isValid()) ? false : true;
    }
}
