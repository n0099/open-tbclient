package com.baidu.swan.apps.w.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f extends c {
    public com.baidu.swan.apps.w.a.a.c dje;
    public boolean djy;
    public double djz;
    public String djx = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.w.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.djx = jSONObject.optString("markerId");
            this.dje = new com.baidu.swan.apps.w.a.a.c();
            this.dje.parseFromJson(jSONObject.optJSONObject("destination"));
            this.djy = jSONObject.optBoolean("autoRotate");
            this.djz = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cMR) || TextUtils.isEmpty(this.cMQ) || TextUtils.isEmpty(this.djx) || this.dje == null || !this.dje.isValid()) ? false : true;
    }
}
