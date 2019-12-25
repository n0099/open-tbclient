package com.baidu.swan.apps.z.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f extends c {
    public com.baidu.swan.apps.z.a.a.c buN;
    public boolean bvh;
    public double bvi;
    public String bvg = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.z.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.bvg = jSONObject.optString("markerId");
            this.buN = new com.baidu.swan.apps.z.a.a.c();
            this.buN.parseFromJson(jSONObject.optJSONObject("destination"));
            this.bvh = jSONObject.optBoolean("autoRotate");
            this.bvi = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bdi) || TextUtils.isEmpty(this.bdh) || TextUtils.isEmpty(this.bvg) || this.buN == null || !this.buN.isValid()) ? false : true;
    }
}
