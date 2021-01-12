package com.baidu.swan.apps.w.a.a;

import androidx.core.view.ViewCompat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a implements com.baidu.swan.apps.model.a {
    public c dfp;
    public int color = 0;
    public int dfO = ViewCompat.MEASURED_STATE_MASK;
    public int radius = -1;
    public float strokeWidth = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("radius")) {
            this.dfp = new c();
            this.dfp.parseFromJson(jSONObject);
            if (this.dfp.isValid()) {
                this.color = com.baidu.swan.apps.w.a.d.V(jSONObject.optString("color"), 0);
                this.dfO = com.baidu.swan.apps.w.a.d.V(jSONObject.optString("fillColor"), ViewCompat.MEASURED_STATE_MASK);
                this.radius = jSONObject.optInt("radius", -1);
                this.strokeWidth = Math.abs(com.baidu.swan.apps.w.a.d.o(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.dfp == null || !this.dfp.isValid() || this.radius == -1) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("coordinate ->").append(this.dfp).append("color ->").append(this.color).append("fillColor ->").append(this.dfO).append("radius ->").append(this.radius).append("strokeWidth ->").append(this.strokeWidth);
        return sb.toString();
    }
}
