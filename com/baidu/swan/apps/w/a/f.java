package com.baidu.swan.apps.w.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f extends c {
    public boolean dfJ;
    public double dfK;
    public com.baidu.swan.apps.w.a.a.c dfp;
    public String dfI = "";
    public int duration = 1000;

    @Override // com.baidu.swan.apps.w.a.c, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.dfI = jSONObject.optString("markerId");
            this.dfp = new com.baidu.swan.apps.w.a.a.c();
            this.dfp.parseFromJson(jSONObject.optJSONObject("destination"));
            this.dfJ = jSONObject.optBoolean("autoRotate");
            this.dfK = jSONObject.optDouble(RotateImageAction.ACTION_NAME);
            this.duration = Math.abs(jSONObject.optInt("duration", this.duration));
        }
    }

    @Override // com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.cJd) || TextUtils.isEmpty(this.cJc) || TextUtils.isEmpty(this.dfI) || this.dfp == null || !this.dfp.isValid()) ? false : true;
    }
}
