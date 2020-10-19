package com.baidu.swan.apps.w.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f extends c {
    public com.baidu.swan.apps.w.a.a.c cLG;
    public boolean cMa;
    public double cMb;
    public String cLZ = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.w.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cLZ = jSONObject.optString("markerId");
            this.cLG = new com.baidu.swan.apps.w.a.a.c();
            this.cLG.parseFromJson(jSONObject.optJSONObject("destination"));
            this.cMa = jSONObject.optBoolean("autoRotate");
            this.cMb = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cpq) || TextUtils.isEmpty(this.cpp) || TextUtils.isEmpty(this.cLZ) || this.cLG == null || !this.cLG.isValid()) ? false : true;
    }
}
