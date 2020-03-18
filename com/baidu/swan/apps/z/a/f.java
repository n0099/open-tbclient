package com.baidu.swan.apps.z.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends c {
    public boolean bAr;
    public double bAs;
    public com.baidu.swan.apps.z.a.a.c bzX;
    public String bAq = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.z.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.bAq = jSONObject.optString("markerId");
            this.bzX = new com.baidu.swan.apps.z.a.a.c();
            this.bzX.parseFromJson(jSONObject.optJSONObject("destination"));
            this.bAr = jSONObject.optBoolean("autoRotate");
            this.bAs = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.biB) || TextUtils.isEmpty(this.biA) || TextUtils.isEmpty(this.bAq) || this.bzX == null || !this.bzX.isValid()) ? false : true;
    }
}
