package com.baidu.swan.apps.w.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends c {
    public boolean cYF;
    public double cYG;
    public com.baidu.swan.apps.w.a.a.c cYl;
    public String cYE = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.w.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cYE = jSONObject.optString("markerId");
            this.cYl = new com.baidu.swan.apps.w.a.a.c();
            this.cYl.parseFromJson(jSONObject.optJSONObject("destination"));
            this.cYF = jSONObject.optBoolean("autoRotate");
            this.cYG = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cCb) || TextUtils.isEmpty(this.cCa) || TextUtils.isEmpty(this.cYE) || this.cYl == null || !this.cYl.isValid()) ? false : true;
    }
}
