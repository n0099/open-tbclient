package com.baidu.swan.apps.x.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends c {
    public com.baidu.swan.apps.x.a.a.c cnA;
    public boolean cnU;
    public double cnV;
    public String cnT = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.x.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cnT = jSONObject.optString("markerId");
            this.cnA = new com.baidu.swan.apps.x.a.a.c();
            this.cnA.parseFromJson(jSONObject.optJSONObject("destination"));
            this.cnU = jSONObject.optBoolean("autoRotate");
            this.cnV = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.bUu) || TextUtils.isEmpty(this.bUt) || TextUtils.isEmpty(this.cnT) || this.cnA == null || !this.cnA.isValid()) ? false : true;
    }
}
