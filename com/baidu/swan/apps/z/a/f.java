package com.baidu.swan.apps.z.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends c {
    public com.baidu.swan.apps.z.a.a.c bYd;
    public boolean bYx;
    public double bYy;
    public String bYw = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.z.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.bYw = jSONObject.optString("markerId");
            this.bYd = new com.baidu.swan.apps.z.a.a.c();
            this.bYd.parseFromJson(jSONObject.optJSONObject("destination"));
            this.bYx = jSONObject.optBoolean("autoRotate");
            this.bYy = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bGJ) || TextUtils.isEmpty(this.bGI) || TextUtils.isEmpty(this.bYw) || this.bYd == null || !this.bYd.isValid()) ? false : true;
    }
}
