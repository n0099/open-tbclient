package com.baidu.swan.apps.x.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends c {
    public com.baidu.swan.apps.x.a.a.c aUd;
    public boolean aUs;
    public double aUt;
    public String aUr = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.x.a.c, com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.aUr = jSONObject.optString("markerId");
            this.aUd = new com.baidu.swan.apps.x.a.a.c();
            this.aUd.parseFromJson(jSONObject.optJSONObject("destination"));
            this.aUs = jSONObject.optBoolean("autoRotate");
            this.aUt = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.model.a.a.a, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.aXH) || TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.aUr) || this.aUd == null || !this.aUd.isValid()) ? false : true;
    }
}
