package com.baidu.swan.apps.z.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f extends c {
    public com.baidu.swan.apps.z.a.a.c bvB;
    public boolean bvV;
    public double bvW;
    public String bvU = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.z.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.bvU = jSONObject.optString("markerId");
            this.bvB = new com.baidu.swan.apps.z.a.a.c();
            this.bvB.parseFromJson(jSONObject.optJSONObject("destination"));
            this.bvV = jSONObject.optBoolean("autoRotate");
            this.bvW = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bdW) || TextUtils.isEmpty(this.bdV) || TextUtils.isEmpty(this.bvU) || this.bvB == null || !this.bvB.isValid()) ? false : true;
    }
}
