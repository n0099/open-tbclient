package com.baidu.swan.apps.w.a.a;

import androidx.core.view.ViewCompat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a implements com.baidu.swan.apps.model.a {
    public c dke;
    public int color = 0;
    public int dkD = ViewCompat.MEASURED_STATE_MASK;
    public int radius = -1;
    public float strokeWidth = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("radius")) {
            this.dke = new c();
            this.dke.parseFromJson(jSONObject);
            if (this.dke.isValid()) {
                this.color = com.baidu.swan.apps.w.a.d.V(jSONObject.optString("color"), 0);
                this.dkD = com.baidu.swan.apps.w.a.d.V(jSONObject.optString("fillColor"), ViewCompat.MEASURED_STATE_MASK);
                this.radius = jSONObject.optInt("radius", -1);
                this.strokeWidth = Math.abs(com.baidu.swan.apps.w.a.d.u(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.dke == null || !this.dke.isValid() || this.radius == -1) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("coordinate ->").append(this.dke).append("color ->").append(this.color).append("fillColor ->").append(this.dkD).append("radius ->").append(this.radius).append("strokeWidth ->").append(this.strokeWidth);
        return sb.toString();
    }
}
