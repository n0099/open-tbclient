package com.baidu.swan.apps.w.a.a;

import android.support.v4.view.ViewCompat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a implements com.baidu.swan.apps.model.a {
    public c cxA;
    public int color = 0;
    public int fillColor = ViewCompat.MEASURED_STATE_MASK;
    public int radius = -1;
    public float strokeWidth = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("radius")) {
            this.cxA = new c();
            this.cxA.parseFromJson(jSONObject);
            if (this.cxA.isValid()) {
                this.color = com.baidu.swan.apps.w.a.d.P(jSONObject.optString("color"), 0);
                this.fillColor = com.baidu.swan.apps.w.a.d.P(jSONObject.optString("fillColor"), ViewCompat.MEASURED_STATE_MASK);
                this.radius = jSONObject.optInt("radius", -1);
                this.strokeWidth = Math.abs(com.baidu.swan.apps.w.a.d.r(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.cxA == null || !this.cxA.isValid() || this.radius == -1) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("coordinate ->").append(this.cxA).append("color ->").append(this.color).append("fillColor ->").append(this.fillColor).append("radius ->").append(this.radius).append("strokeWidth ->").append(this.strokeWidth);
        return sb.toString();
    }
}
