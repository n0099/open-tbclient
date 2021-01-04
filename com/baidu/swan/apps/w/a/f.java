package com.baidu.swan.apps.w.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f extends c {
    public com.baidu.swan.apps.w.a.a.c dke;
    public boolean dky;
    public double dkz;
    public String dkx = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.w.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.dkx = jSONObject.optString("markerId");
            this.dke = new com.baidu.swan.apps.w.a.a.c();
            this.dke.parseFromJson(jSONObject.optJSONObject("destination"));
            this.dky = jSONObject.optBoolean("autoRotate");
            this.dkz = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cNP) || TextUtils.isEmpty(this.cNO) || TextUtils.isEmpty(this.dkx) || this.dke == null || !this.dke.isValid()) ? false : true;
    }
}
