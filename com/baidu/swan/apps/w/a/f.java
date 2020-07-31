package com.baidu.swan.apps.w.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends c {
    public com.baidu.swan.apps.w.a.a.c cpG;
    public boolean cqa;
    public double cqb;
    public String cpZ = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.w.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cpZ = jSONObject.optString("markerId");
            this.cpG = new com.baidu.swan.apps.w.a.a.c();
            this.cpG.parseFromJson(jSONObject.optJSONObject("destination"));
            this.cqa = jSONObject.optBoolean("autoRotate");
            this.cqb = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bVm) || TextUtils.isEmpty(this.bVl) || TextUtils.isEmpty(this.cpZ) || this.cpG == null || !this.cpG.isValid()) ? false : true;
    }
}
