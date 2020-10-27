package com.baidu.swan.apps.w.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f extends c {
    public com.baidu.swan.apps.w.a.a.c cUc;
    public boolean cUw;
    public double cUx;
    public String cUv = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.w.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cUv = jSONObject.optString("markerId");
            this.cUc = new com.baidu.swan.apps.w.a.a.c();
            this.cUc.parseFromJson(jSONObject.optJSONObject("destination"));
            this.cUw = jSONObject.optBoolean("autoRotate");
            this.cUx = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cxS) || TextUtils.isEmpty(this.cxR) || TextUtils.isEmpty(this.cUv) || this.cUc == null || !this.cUc.isValid()) ? false : true;
    }
}
