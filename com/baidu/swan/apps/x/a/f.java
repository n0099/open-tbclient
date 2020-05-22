package com.baidu.swan.apps.x.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends c {
    public com.baidu.swan.apps.x.a.a.c ciL;
    public boolean cjf;
    public double cjg;
    public String cje = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.x.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cje = jSONObject.optString("markerId");
            this.ciL = new com.baidu.swan.apps.x.a.a.c();
            this.ciL.parseFromJson(jSONObject.optJSONObject("destination"));
            this.cjf = jSONObject.optBoolean("autoRotate");
            this.cjg = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bPG) || TextUtils.isEmpty(this.bPF) || TextUtils.isEmpty(this.cje) || this.ciL == null || !this.ciL.isValid()) ? false : true;
    }
}
