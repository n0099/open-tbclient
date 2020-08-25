package com.baidu.swan.apps.w.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f extends c {
    public boolean cxQ;
    public double cxR;
    public com.baidu.swan.apps.w.a.a.c cxw;
    public String cxP = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.w.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cxP = jSONObject.optString("markerId");
            this.cxw = new com.baidu.swan.apps.w.a.a.c();
            this.cxw.parseFromJson(jSONObject.optJSONObject("destination"));
            this.cxQ = jSONObject.optBoolean("autoRotate");
            this.cxR = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.caU) || TextUtils.isEmpty(this.caT) || TextUtils.isEmpty(this.cxP) || this.cxw == null || !this.cxw.isValid()) ? false : true;
    }
}
