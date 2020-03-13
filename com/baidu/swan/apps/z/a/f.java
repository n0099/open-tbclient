package com.baidu.swan.apps.z.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends c {
    public boolean bAg;
    public double bAh;
    public com.baidu.swan.apps.z.a.a.c bzM;
    public String bAf = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.z.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.bAf = jSONObject.optString("markerId");
            this.bzM = new com.baidu.swan.apps.z.a.a.c();
            this.bzM.parseFromJson(jSONObject.optJSONObject("destination"));
            this.bAg = jSONObject.optBoolean("autoRotate");
            this.bAh = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bin) || TextUtils.isEmpty(this.bim) || TextUtils.isEmpty(this.bAf) || this.bzM == null || !this.bzM.isValid()) ? false : true;
    }
}
