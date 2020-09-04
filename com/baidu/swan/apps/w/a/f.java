package com.baidu.swan.apps.w.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f extends c {
    public com.baidu.swan.apps.w.a.a.c cxA;
    public boolean cxU;
    public double cxV;
    public String cxT = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.w.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cxT = jSONObject.optString("markerId");
            this.cxA = new com.baidu.swan.apps.w.a.a.c();
            this.cxA.parseFromJson(jSONObject.optJSONObject("destination"));
            this.cxU = jSONObject.optBoolean("autoRotate");
            this.cxV = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.caY) || TextUtils.isEmpty(this.caX) || TextUtils.isEmpty(this.cxT) || this.cxA == null || !this.cxA.isValid()) ? false : true;
    }
}
