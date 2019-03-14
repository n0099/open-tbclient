package com.baidu.swan.apps.x.a.a;

import android.support.v4.view.ViewCompat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();
    public c ayI;
    public int color = 0;
    public int fillColor = ViewCompat.MEASURED_STATE_MASK;
    public int radius = -1;
    public float azc = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("radius")) {
            this.ayI = new c();
            this.ayI.parseFromJson(jSONObject);
            if (this.ayI.isValid()) {
                this.color = com.baidu.swan.apps.x.a.d.E(jSONObject.optString("color"), 0);
                this.fillColor = com.baidu.swan.apps.x.a.d.E(jSONObject.optString("fillColor"), ViewCompat.MEASURED_STATE_MASK);
                this.radius = jSONObject.optInt("radius", -1);
                this.azc = Math.abs(com.baidu.swan.apps.x.a.d.f(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.ayI == null || !this.ayI.isValid() || this.radius == -1) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("coordinate ->").append(this.ayI).append("color ->").append(this.color).append("fillColor ->").append(this.fillColor).append("radius ->").append(this.radius).append("strokeWidth ->").append(this.azc);
        return sb.toString();
    }
}
