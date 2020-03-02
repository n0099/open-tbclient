package com.baidu.swan.apps.z.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends c {
    public boolean bAf;
    public double bAg;
    public com.baidu.swan.apps.z.a.a.c bzL;
    public String bAe = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.z.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.bAe = jSONObject.optString("markerId");
            this.bzL = new com.baidu.swan.apps.z.a.a.c();
            this.bzL.parseFromJson(jSONObject.optJSONObject("destination"));
            this.bAf = jSONObject.optBoolean("autoRotate");
            this.bAg = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bim) || TextUtils.isEmpty(this.bil) || TextUtils.isEmpty(this.bAe) || this.bzL == null || !this.bzL.isValid()) ? false : true;
    }
}
