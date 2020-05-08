package com.baidu.swan.apps.z.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends c {
    public boolean bYD;
    public double bYE;
    public com.baidu.swan.apps.z.a.a.c bYj;
    public String bYC = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.z.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.bYC = jSONObject.optString("markerId");
            this.bYj = new com.baidu.swan.apps.z.a.a.c();
            this.bYj.parseFromJson(jSONObject.optJSONObject("destination"));
            this.bYD = jSONObject.optBoolean("autoRotate");
            this.bYE = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bGO) || TextUtils.isEmpty(this.bGN) || TextUtils.isEmpty(this.bYC) || this.bYj == null || !this.bYj.isValid()) ? false : true;
    }
}
