package com.baidu.swan.apps.x.a.a;

import android.support.v4.view.ViewCompat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();
    public c ciL;
    public int color = 0;
    public int cjk = ViewCompat.MEASURED_STATE_MASK;
    public int radius = -1;
    public float strokeWidth = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("radius")) {
            this.ciL = new c();
            this.ciL.parseFromJson(jSONObject);
            if (this.ciL.isValid()) {
                this.color = com.baidu.swan.apps.x.a.d.N(jSONObject.optString("color"), 0);
                this.cjk = com.baidu.swan.apps.x.a.d.N(jSONObject.optString("fillColor"), ViewCompat.MEASURED_STATE_MASK);
                this.radius = jSONObject.optInt("radius", -1);
                this.strokeWidth = Math.abs(com.baidu.swan.apps.x.a.d.k(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.ciL == null || !this.ciL.isValid() || this.radius == -1) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("coordinate ->").append(this.ciL).append("color ->").append(this.color).append("fillColor ->").append(this.cjk).append("radius ->").append(this.radius).append("strokeWidth ->").append(this.strokeWidth);
        return sb.toString();
    }
}
