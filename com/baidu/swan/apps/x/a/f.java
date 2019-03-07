package com.baidu.swan.apps.x.a;

import android.text.TextUtils;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends c {
    public com.baidu.swan.apps.x.a.a.c ayH;
    public boolean ayW;
    public double ayX;
    public String ayV = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.x.a.c, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.ayV = jSONObject.optString("markerId");
            this.ayH = new com.baidu.swan.apps.x.a.a.c();
            this.ayH.parseFromJson(jSONObject.optJSONObject("destination"));
            this.ayW = jSONObject.optBoolean("autoRotate");
            this.ayX = jSONObject.optDouble("rotate");
            this.duration = Math.abs(jSONObject.optInt(UBC.CONTENT_KEY_DURATION, this.duration));
        }
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.aBC) || TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.ayV) || this.ayH == null || !this.ayH.isValid()) ? false : true;
    }
}
