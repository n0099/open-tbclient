package com.baidu.swan.apps.x.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends c {
    public com.baidu.swan.apps.x.a.a.c aTL;
    public boolean aUa;
    public double aUb;
    public String aTZ = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.x.a.c, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.aTZ = jSONObject.optString("markerId");
            this.aTL = new com.baidu.swan.apps.x.a.a.c();
            this.aTL.parseFromJson(jSONObject.optJSONObject("destination"));
            this.aUa = jSONObject.optBoolean("autoRotate");
            this.aUb = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.aXp) || TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.aTZ) || this.aTL == null || !this.aTL.isValid()) ? false : true;
    }
}
