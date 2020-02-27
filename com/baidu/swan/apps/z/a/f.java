package com.baidu.swan.apps.z.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends c {
    public boolean bAe;
    public double bAf;
    public com.baidu.swan.apps.z.a.a.c bzK;
    public String bAd = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.z.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.bAd = jSONObject.optString("markerId");
            this.bzK = new com.baidu.swan.apps.z.a.a.c();
            this.bzK.parseFromJson(jSONObject.optJSONObject("destination"));
            this.bAe = jSONObject.optBoolean("autoRotate");
            this.bAf = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bil) || TextUtils.isEmpty(this.bik) || TextUtils.isEmpty(this.bAd) || this.bzK == null || !this.bzK.isValid()) ? false : true;
    }
}
