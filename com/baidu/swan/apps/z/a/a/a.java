package com.baidu.swan.apps.z.a.a;

import android.support.v4.view.ViewCompat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a implements com.baidu.swan.apps.model.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();
    public c buN;
    public int color = 0;
    public int bvm = ViewCompat.MEASURED_STATE_MASK;
    public int radius = -1;
    public float bvn = 0.0f;

    @Override // com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("radius")) {
            this.buN = new c();
            this.buN.parseFromJson(jSONObject);
            if (this.buN.isValid()) {
                this.color = com.baidu.swan.apps.z.a.d.D(jSONObject.optString("color"), 0);
                this.bvm = com.baidu.swan.apps.z.a.d.D(jSONObject.optString("fillColor"), ViewCompat.MEASURED_STATE_MASK);
                this.radius = jSONObject.optInt("radius", -1);
                this.bvn = Math.abs(com.baidu.swan.apps.z.a.d.f(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // com.baidu.swan.apps.model.a
    public boolean isValid() {
        return (this.buN == null || !this.buN.isValid() || this.radius == -1) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("coordinate ->").append(this.buN).append("color ->").append(this.color).append("fillColor ->").append(this.bvm).append("radius ->").append(this.radius).append("strokeWidth ->").append(this.bvn);
        return sb.toString();
    }
}
