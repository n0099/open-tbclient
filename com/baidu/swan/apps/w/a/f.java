package com.baidu.swan.apps.w.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class f extends c {
    public boolean dfE;
    public double dfF;
    public com.baidu.swan.apps.w.a.a.c dfk;
    public String dfD = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.w.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.dfD = jSONObject.optString("markerId");
            this.dfk = new com.baidu.swan.apps.w.a.a.c();
            this.dfk.parseFromJson(jSONObject.optJSONObject("destination"));
            this.dfE = jSONObject.optBoolean("autoRotate");
            this.dfF = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cIW) || TextUtils.isEmpty(this.cIV) || TextUtils.isEmpty(this.dfD) || this.dfk == null || !this.dfk.isValid()) ? false : true;
    }
}
