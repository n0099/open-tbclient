package com.baidu.swan.apps.w.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f extends c {
    public com.baidu.swan.apps.w.a.a.c cZV;
    public boolean dap;
    public double daq;
    public String dao = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.w.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.dao = jSONObject.optString("markerId");
            this.cZV = new com.baidu.swan.apps.w.a.a.c();
            this.cZV.parseFromJson(jSONObject.optJSONObject("destination"));
            this.dap = jSONObject.optBoolean("autoRotate");
            this.daq = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cDL) || TextUtils.isEmpty(this.cDK) || TextUtils.isEmpty(this.dao) || this.cZV == null || !this.cZV.isValid()) ? false : true;
    }
}
