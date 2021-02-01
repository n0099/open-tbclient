package com.baidu.swan.apps.w.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f extends c {
    public com.baidu.swan.apps.w.a.a.c dhA;
    public boolean dhU;
    public double dhV;
    public String dhT = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.w.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.dhT = jSONObject.optString("markerId");
            this.dhA = new com.baidu.swan.apps.w.a.a.c();
            this.dhA.parseFromJson(jSONObject.optJSONObject("destination"));
            this.dhU = jSONObject.optBoolean("autoRotate");
            this.dhV = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cLr) || TextUtils.isEmpty(this.cLq) || TextUtils.isEmpty(this.dhT) || this.dhA == null || !this.dhA.isValid()) ? false : true;
    }
}
