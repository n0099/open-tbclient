package com.baidu.swan.apps.w.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends c {
    public com.baidu.swan.apps.w.a.a.c czB;
    public boolean czV;
    public double czW;
    public String czU = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.w.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.czU = jSONObject.optString("markerId");
            this.czB = new com.baidu.swan.apps.w.a.a.c();
            this.czB.parseFromJson(jSONObject.optJSONObject("destination"));
            this.czV = jSONObject.optBoolean("autoRotate");
            this.czW = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cda) || TextUtils.isEmpty(this.ccZ) || TextUtils.isEmpty(this.czU) || this.czB == null || !this.czB.isValid()) ? false : true;
    }
}
