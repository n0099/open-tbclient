package com.baidu.swan.apps.x.a;

import android.text.TextUtils;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends c {
    public com.baidu.swan.apps.x.a.a.c ayI;
    public boolean ayX;
    public double ayY;
    public String ayW = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.x.a.c, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.ayW = jSONObject.optString("markerId");
            this.ayI = new com.baidu.swan.apps.x.a.a.c();
            this.ayI.parseFromJson(jSONObject.optJSONObject("destination"));
            this.ayX = jSONObject.optBoolean("autoRotate");
            this.ayY = jSONObject.optDouble("rotate");
            this.duration = Math.abs(jSONObject.optInt(UBC.CONTENT_KEY_DURATION, this.duration));
        }
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.aBD) || TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.ayW) || this.ayI == null || !this.ayI.isValid()) ? false : true;
    }
}
